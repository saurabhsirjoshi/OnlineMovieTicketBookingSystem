package omtbs.core;

import java.util.Date;

public class OMTBSFascade {
	long sessionID;
	
	public long getSessionID() {
		Date d = new Date();
		sessionID = d.getTime();
		return sessionID;
	}
	
	public boolean loginUser(String uName, String pwd) {
		return true;
	}
	// Procedure to contact Adapter and book tickets
	public void bookTickets() {
		
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
