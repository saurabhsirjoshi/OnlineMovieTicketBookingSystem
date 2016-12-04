package omtbs.core;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class TaskHandler {
	public static void main(String[] args) throws IOException {
		//Declare variables
		String userName, passWord, movie, theatre, tempInput, bookingDate, version;
		int noOfSeats;
		boolean loopcondition;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Create a Fascade object
		OMTBSFascade fasc = new OMTBSFascade();
		
		//Begin
		System.out.println("Welcome to the Online Movie Ticket Booking System!");
		//Get user details:
		System.out.print("Enter username: ");
		userName = br.readLine();
		System.out.print("Enter password: ");
		passWord = br.readLine();
		//Create session
		long sessionID = fasc.getSessionID();
		
		//On successful Login the user to use OMTBS, perform tasks
		if (fasc.loginUser(userName, passWord)) {
			loopcondition = true;
			while (loopcondition) {
				tempInput = "";
				System.out.println("**************************************************");
				System.out.println("Welcome to the Online Movie Ticket Booking System!");
				System.out.println("Hi " + userName +"!");
				System.out.println("Menu:");
				System.out.println("1) Book Tickets");
				System.out.println("2) View History");
				System.out.println("3) Show current list of movies");
				System.out.println("4) Logout");
				System.out.print("Enter choice: ");
				tempInput = br.readLine();
				switch(tempInput) {
					case "1":
						System.out.print("Enter Movie ID: ");
						movie = br.readLine();
						System.out.print("Enter Theatre ID: ");
						theatre = br.readLine();
						System.out.print("Enter Number of seats: ");
						noOfSeats = Integer.parseInt(br.readLine());
						System.out.print("Enter Movie Date (MM/DD/YY): ");
						bookingDate = br.readLine();
						System.out.print("Enter System version: ");
						version = br.readLine();
						fasc.prodVersion = version;
						fasc.bookTickets(movie,theatre, noOfSeats, bookingDate);
						break;
					case "2":
						System.out.println(fasc.getHistory());
						break;
					case "3":
						System.out.print("Enter Movie Date (MM/DD/YY): ");
						bookingDate = br.readLine();
						System.out.print("Enter Theatre ID: ");
						theatre = br.readLine();
						System.out.println(fasc.getMoviesList(bookingDate, theatre));
						break;
					case "4":
						fasc.logoutUser();
						loopcondition = false;
						System.out.print("Log off successful!");
						break;
					default:
						System.out.print("Invalid Input! Please re-enter!");
						break;
				}
			}
		}
		else
			System.out.println("Invalid user!");
	}
}
