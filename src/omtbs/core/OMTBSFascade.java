package omtbs.core;

import java.util.Date;

public class OMTBSFascade {
	long sessionID;
	String userName;
	//Create a new session for new user
	public long getSessionID() {
		Date d = new Date();
		sessionID = d.getTime();
		return sessionID;
	}
	//Validate user
	public boolean loginUser(String uName, String pwd) {
		if (uName.equals("TestUser") && pwd.equals("Test!23")) {
			this.userName = uName;
			return true;
		}
		else
			return false;
	}
	//Log user out and invalidate session
	public boolean logoutUser() {
		sessionID = 0;
		return true;
	}
	// Procedure to book tickets
	public void bookTickets(String aMovie, String aTheatre, int aNoOfSeats, String aDate) {
		
	}
	
	public String getMoviesList() {
		return "";
	}
	
	// Procedure to contact DB for history
	public String getHistory() {
		String historyText = "";
		//Calls DB Adapter
		return historyText;
	}
	
	//Procedure to connect to payment gateways
	public String payTicket() {
		String paymentStatus = "";
		//Calls Payment proxy
		return paymentStatus;
	}
	
	
}
