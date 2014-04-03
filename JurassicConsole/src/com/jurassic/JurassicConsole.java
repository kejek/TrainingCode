package com.jurassic;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jurassic.persist.DinosaurItem;
/**
 * @{link JurassicConsole} console to play with option choices and 
 * database access similiar to the movie Jurassic Park.
 * 
 * @author Matt Goldsworthy
 */
public class JurassicConsole {
	/*
	 * TextDevice is used as a console when using an IDE like eclipse.
	 * Console is usually null when compiled within eclipse.
	 */
	static final TextDevice con = TextDevices.defaultTextDevice();

	public static void main(String[] args) {

		login();

	}

	public static boolean login() {
		int i = 0;
		int x = 3; // number of attempts to authenticate

		// Console con = System.console();
		boolean auth = false;
		boolean exit = true;
		
		
		if (con != null) {

			while (i < x) {
				//basic login entry.
				con.printf("Enter your username: ");
				String uname = con.readLine();
				con.printf("Enter your password:");
				char[] pwd = con.readPassword();
				
				//call authorization method
				auth = authorize(uname, pwd);
				
				
				if (!auth) {
					i++;
					//user can only attempt so many times before application exits.					/
					if (i == x) {
						System.out.println("Too many attempts. Exiting...");
						break;
					}
					
				//successful authorization, begin systemMain method
				} else {
					exit = systemMain(uname);
					//systemMain can return false, which tells the application to exit.
					if (!exit) {
						break;
					}
				}
			}
		}
		return true;
	}

	//Simply returns a text string to the console
	public static void cantDo(String uname) {
		System.out.println("I can't let you do that, " + uname + "...");
	}
	
	//Simple hello message returned to the console
	public static void hello(String uname) {
		System.out.println("");
		System.out
				.println("Welcome "
						+ uname
						+ " to Jurassic Park Systems version 1.0.1.1 - July 20th, 1992...");

	}

	/*
	 * Authorizes user. Usually, we would use a database with encrypted passwords to authenticate.
	 * For simplicity we are using a hardcoded password.
	 */
	public static boolean authorize(String uname, char[] pwd) {
		char[] pass = { 'q', 'a', 'z', 'w', 's', 'x', '1', '2', '3', '4', '!' };

		if (Arrays.equals(pass, pwd)) {
			hello(uname);
			return true;
		} else {
			cantDo(uname);
			return false;

		}

	}

	/*
	 * Main method for operations. This method returns a boolean.
	 * If the boolean returned is false we can perform other logic based
	 * on business rules for system shut down. Otherwise once the method has been
	 * left we can cleanly shut down the application.
	 */
	public static boolean systemMain(String uname) {
		char[] pass = { 'p', 'l', 'e', 'a', 's', 'e' };
		int i = 0;

		// Console con = System.console();
		if (con != null) {
			while (i < 10) {
				
				//Main menu
				System.out.println("Please select an option -");
				System.out.println("1) System Settings");
				System.out.println("2) Security");
				System.out.println("3) System Shutdown");
				System.out.println("4) Query Database");
				String choice = con.readLine();
				
				/*
				 * Secret password check for shutting down the system.
				 * If the password is incorrect, we exit back to main menu
				 * with a message that the magic word was not typed.
				 */
				if (choice.equals("3")) {
					System.out.println("");
					con.printf("Enter secret password: ");
					char[] pwd = con.readPassword();

					if (Arrays.equals(pass, pwd)) {
						
						//Password was correct, shut system down and exit with False
						System.out.println("");
						System.out.println("System shutting down...");

						return false;
					} else {
						System.out.println("");
						System.out
								.println("Nuh uh uhhh... You didn't say the magic word!");
					}
				} else if (choice.equals("exit")) {
					return false;
				
				/*
				 * User wants to query database. We use Derby for a simple
				 * database to connect to, with a small selection of Dinos.
				 * The query is very simplistic and can handle just a few options
				 */
				} else if (choice.equals("4")) {
					System.out
							.println("Enter query: (Try select mi from DinosaurItem mi)");
					String query = con.readLine();
					queryDino(query);
				} else {
					
					/*
					 * If an option is not correctly configured yet
					 * this will catch and display a message to the 
					 * user that the option is not availble.
					 */
					System.out.println("");
					System.out
							.println("System has not correctly been configured for that option. Try again.");
				}
			}

		}
		return false;

	}
	
	/*
	 * Querying our database. This method handles the connection,
	 * querying, and display from the database.
	 * 
	 */
	public static void queryDino(String query) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("dinosaurs");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			TypedQuery<DinosaurItem> q = em.createQuery(query,
					DinosaurItem.class);
			List<DinosaurItem> resultList = q.getResultList();
			System.out.println("ID | NAME | SPECIES | AGE | LOCATION");
			for (DinosaurItem cur : resultList) {				
				System.out.println(cur);
			}
			System.out.println("***");

			/*
			 * This section would allow an insert into the database.
			 */
			/*
			 * DinosaurItem newItem = new DinosaurItem();
			 * newItem.setName("Madonna"); newItem.setSpecies("Stegosaurus");
			 * newItem.setAge(3); newItem.setLocation("Grid 2");
			 * em.persist(newItem);
			 * 
			 * // Query again - should have our new item. resultList =
			 * q.getResultList(); for (DinosaurItem cur : resultList) {
			 * System.out.println(cur); }
			 * 
			 * em.getTransaction().commit();
			 */

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}


}
