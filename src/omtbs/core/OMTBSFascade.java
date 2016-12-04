package omtbs.core;

import java.util.Date;

import omtbs.database.AbstractDAO;
import omtbs.database.DAOAbstractFactory;
import omtbs.database.DAOFactoryProducer;

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
		String movieList;
		DAOFactoryProducer facProd = new DAOFactoryProducer();
		DAOAbstractFactory absFac = facProd.getFactory("DBFactory");
		AbstractDAO orclDB = absFac.getDB("oracle");
		//AbstractDAO mySQLDB = absFac.getDB("mysql");
		movieList = orclDB.selectFromDB("select * from bookings where user='" + userName + "'");
		return movieList;
	}
	
	// Procedure to contact DB for history
	public String getHistory() {
		String historyText = "";
		//Calls DB Adapter
		DAOFactoryProducer facProd = new DAOFactoryProducer();
		DAOAbstractFactory absFac = facProd.getFactory("DBFactory");
		//AbstractDAO orclDB = absFac.getDB("oracle");
		AbstractDAO mySQLDB = absFac.getDB("mysql");
		historyText = mySQLDB.selectFromDB("select * from bookings where user='" + userName + "'");
		return historyText;
	}
	
	//Procedure to connect to payment gateways
	public String payTicket() {
		String paymentStatus = "";
		//Calls Payment proxy
		return paymentStatus;
	}
	
	
}
