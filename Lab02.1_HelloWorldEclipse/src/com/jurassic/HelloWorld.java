package com.jurassic;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jurassic.persist.DinosaurItem;

public class HelloWorld {
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
				con.printf("Enter your username: ");
				String uname = con.readLine();
				con.printf("Enter your password:");
				char[] pwd = con.readPassword();

				auth = authorize(uname, pwd);

				if (!auth) {
					i++;
					if (i == x) {
						System.out.println("Too many attempts. Exiting...");
					}
				} else {
					exit = systemMain(uname);
					if (!exit) {
						break;
					}
				}
			}
		}
		return true;
	}

	public static void cantDo(String uname) {
		System.out.println("I can't let you do that, " + uname + "...");
	}

	public static void hello(String uname) {
		System.out.println("");
		System.out
				.println("Welcome "
						+ uname
						+ " to Jurassic Park Systems version 1.0.1.1 - July 20th, 1992...");

	}

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

	public static boolean systemMain(String uname) {
		char[] pass = { 'p', 'l', 'e', 'a', 's', 'e' };
		int i = 0;

		// Console con = System.console();
		if (con != null) {
			while (i < 10) {

				System.out.println("Please select an option -");
				System.out.println("1) System Settings");
				System.out.println("2) Security");
				System.out.println("3) System Shutdown");
				System.out.println("4) Query Database");
				String choice = con.readLine();

				if (choice.equals("3")) {
					System.out.println("");
					con.printf("Enter secret password: ");
					char[] pwd = con.readPassword();

					if (Arrays.equals(pass, pwd)) {

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
				} else if (choice.equals("4")) {
					System.out
							.println("Enter query: (Try select * from dinos)");
					String query = con.readLine();
					queryDino(query);
				} else {

					System.out.println("");
					System.out
							.println("System has not correctly been configured for that option. Try again.");
				}
			}

		}
		return false;

	}

	public static void queryDino(String query) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("dinosaurs");
		EntityManager em = null;
		em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			// TODO: Use the EntityManger to find the MusicItem by the id
			// declared above.
			TypedQuery<DinosaurItem> q = em.createQuery(query,
					DinosaurItem.class);
			List<DinosaurItem> resultList = q.getResultList();
			System.out.println("ID | NAME | SPECIES | AGE | LOCATION");
			for (DinosaurItem cur : resultList) {				
				System.out.println(cur);
			}
			System.out.println("***");

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
