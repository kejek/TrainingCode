import java.io.*;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class HelloWorld {
	
	public static void main(String[] args) {
		login();
		
	}
	public static boolean login(){
		int i = 0;
		int x = 3; //number of attempts to authenticate
		Console con = System.console();
		boolean auth = false;
		boolean exit = true;
	   if (con != null){

			while (i < x){ 
				
				String uname = con.readLine("Enter your Username: ");
				char[] pwd = con.readPassword("Enter your Password: ");
	
				auth = authorize(uname, pwd);
				
				if (!auth){
					i++;
					if (i == x){
						System.out.println("Too many attempts. Exiting...");
					}
				}
				else{
					exit = systemMain(uname);
					if (!exit){
						break;
					}
				}
			}
	   }
		return true;
	}
	public static void cantDo(String uname){
		System.out.println("I can't let you do that, " + uname + "...");
	}
	public static void hello(String uname){
		System.out.println("");
		System.out.println("Welcome "+ uname + " to Jurassic Park Systems version 1.0.1.1 - July 20th, 1992...");
		
	}
	public static boolean authorize(String uname, char[] pwd){
		char[] pass = {'q','a','z','w','s','x','1','2','3','4','!'};
		
			if (Arrays.equals(pass, pwd)) {
				hello(uname);
				return true;
			}	
			else {						
				cantDo(uname);
				return false;
							
			}
		
	}

	public static boolean systemMain(String uname){
		char[] pass = {'p','l','e','a','s','e'};
		int i = 0;
		
		Console con = System.console();
	   if (con != null){
		   while(i < 10){
			   
				System.out.println("Please select an option -");
				System.out.println("1) System Settings");
				System.out.println("2) Security");
				System.out.println("3) System Shutdown");
				String choice = con.readLine("[]");
				
				if (choice.equals("3")){
					System.out.println("");
					char[] pwd = con.readPassword("Enter secret password: ");
					
					if (Arrays.equals(pass, pwd)){

						System.out.println("");
						System.out.println("System shutting down...");
						
						return false;
					}
					else{
						System.out.println("");
						System.out.println("Nuh uh uhhh... You didn't say the magic word!");
					}
				}
				else if (choice.equals("exit")){
			    	return false;
			    }
			    else{
			    	System.out.println("");
			    	System.out.println("System has not correctly been configured for that option. Try again.");
			    }
		   }
	
	   }
	   return false;
		
	}

}
