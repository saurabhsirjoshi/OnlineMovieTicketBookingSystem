package omtbs.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import omtbs.adapter.IMAXAdapter;
import omtbs.adapter.LegacyAdapter;
import omtbs.adapter.OMTBSAdapter;
import omtbs.database.AbstractDAO;
import omtbs.database.DAOAbstractFactory;
import omtbs.database.DAOFactoryProducer;
import omtbs.payments.Payment;
import omtbs.payments.PaymentProxy;

public class OMTBSFascade {
	long sessionID;
	String userName, prodVersion;
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
	public void bookTickets(String aMovie, String aTheatre, int aNoOfSeats, String aDate) throws IOException {
		String availSeats;
		if (prodVersion.equalsIgnoreCase("IMAX")) {
			OMTBSAdapter imaxAdap = new IMAXAdapter();
			imaxAdap.bookTickets(userName, aMovie, aDate, aTheatre);
		}
		else if (prodVersion.equalsIgnoreCase("LEGACY")) {
			OMTBSAdapter legAdap = new LegacyAdapter();
			legAdap.bookTickets(userName, aMovie, aDate, aTheatre);
		}
		else {
			DAOFactoryProducer facProd = new DAOFactoryProducer();
			DAOAbstractFactory absFac = facProd.getFactory("DBFactory");
			AbstractDAO orclDB = absFac.getDB("oracle");
			if(orclDB.connectToDB("orcl", "dba", "pass!23")) {
				availSeats = orclDB.selectFromDB("select seats from theatreShows where "
						+ "movie = " + aMovie
						+ "theatre = " + aTheatre
						+ "date = " + aDate);
				availSeats = "10";
				if(Integer.parseInt(availSeats) >= aNoOfSeats) {
					System.out.println(payTicket());
				}
			}
		}
	}
	
	public String getMoviesList(String aDate, String aTheatre) {
		String movieList ="";
		if (prodVersion.equalsIgnoreCase("IMAX")) {
			OMTBSAdapter imaxAdap = new IMAXAdapter();
			imaxAdap.searchMovies(aDate, aTheatre);
		}
		else if (prodVersion.equalsIgnoreCase("LEGACY")) {
			OMTBSAdapter legAdap = new LegacyAdapter();
			legAdap.searchMovies(aDate, aTheatre);
		}
		else {
			DAOFactoryProducer facProd = new DAOFactoryProducer();
			DAOAbstractFactory absFac = facProd.getFactory("DBFactory");
			AbstractDAO orclDB = absFac.getDB("oracle");
			//AbstractDAO mySQLDB = absFac.getDB("mysql");
			if(orclDB.connectToDB("orcl", "dba", "pass!23")) {
				movieList = orclDB.selectFromDB("select * from bookings where user='" + userName + "'");
			}
		}
		return movieList;
	}
	
	// Procedure to contact DB for history
	public String getHistory() {
		String historyText = "";
		if (prodVersion.equalsIgnoreCase("IMAX")) {
			OMTBSAdapter imaxAdap = new IMAXAdapter();
			imaxAdap.getHistory(userName);
		}
		else if (prodVersion.equalsIgnoreCase("LEGACY")) {
			OMTBSAdapter legAdap = new LegacyAdapter();
			legAdap.getHistory(userName);
		}
		else {
			//Calls DB Adapter
			DAOFactoryProducer facProd = new DAOFactoryProducer();
			DAOAbstractFactory absFac = facProd.getFactory("DBFactory");
			//AbstractDAO orclDB = absFac.getDB("oracle");
			AbstractDAO mySQLDB = absFac.getDB("mysql");
			if(mySQLDB.connectToDB("mysql", "dba", "pass!23")) {
				historyText = mySQLDB.selectFromDB("select * from bookings where user='" + userName + "'");
			}
		}
		return historyText;
	}
	
	//Procedure to connect to payment gateways
	public String payTicket() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String payType, payDetails, paymentStatus = "";
		String[] paymentDetails = new String[5];
		double amount = 122;
		
		System.out.print("Enter PaymentType: ");
		payType = br.readLine();
		System.out.print("Enter Payment Details: ");
		payDetails = br.readLine();
		paymentDetails[0] = payType;
		paymentDetails[1] = payDetails;
		paymentDetails[2] = "1234567890123456";
		paymentDetails[3] = "121";
		paymentDetails[4] = "2020-10-12";
		
		//Calls Payment proxy
		Payment payProxy = new PaymentProxy();
		if(payProxy.payTickets(paymentDetails, amount)) {
			paymentStatus = "Payment of $" + amount + " successfully charged to " 
					+ paymentDetails[0] + " - " + paymentDetails[1] + " - " 
							+ paymentDetails[2] + " - " + paymentDetails[3] + " - " 
									+ paymentDetails[4];
		}
		else
			paymentStatus = "Payment declined!";
		
		return paymentStatus;
	}
}
