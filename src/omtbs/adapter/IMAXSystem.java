package omtbs.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IMAXSystem {
	
	public boolean IMAXBookTicket(String custName, String movie, String dateTime, String location){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double amount = 0;
		try {
			String cont = "Y";
			while(cont.equals("Y")){
				System.out.println("Enter row number");
				String row = br.readLine();
				System.out.println("Enter seat number");
				String seat = br.readLine();
				if(checkAvailability(movie, dateTime, location, row, seat)){
					System.out.println("Seats booked successfully!");
					System.out.println("Details: ");
					System.out.println("Movie Name: "+movie+" Date and Time: "+dateTime+"Seat Number: "+row+" "+seat);
					amount = amount + getSeatAmount(movie, dateTime, row, seat);
					System.out.println("Do you want to book another seat? (Y/N)");
					cont = br.readLine();
					if(cont.equals("Y"))
						continue;
					else
						break;
				}
				else{
					System.out.println("Please try other seat/time/movie");
					System.out.println("Do you want to book another seat? (Y/N)");
					cont = br.readLine();
					if(cont.equals("Y"))
						continue;
					else
						break;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (IMAXMakePayment(custName, amount));
	}
	
	private double getSeatAmount(String movie, String dateTime, String row, String seat) {
		// TODO Auto-generated method stub
		return 10;
	}

	private boolean checkAvailability(String movie, String dateTime, String location, String row, String seat) {
		// TODO Auto-generated method stub
		return true;
	}

	public void IMAXGetHistory(String custName){
		if(checkBookingHist(custName)){
			System.out.println("Retreiving user booking history from database..");
			System.out.println("Date: 10/23/2016 Time: 3:00 P.M. Movie Name: Doctor Strange Location: Cinemark, Tucson");
			System.out.println("Date: 10/15/2016 Time: 10:00 P.M. Movie Name: Inferno Location: Cinemark, Tucson");
			System.out.println("Date: 09/12/2016 Time: 10:00 P.M. Movie Name: The Wild Life Location: Cinemark, Tucson");
		}
		else
			System.out.println("No booking history available for user: "+custName);

	}

	private boolean checkBookingHist(String custName) {
		// TODO Auto-generated method stub
		return true;
	}

	public void IMAXSrchMovies(String date, String location){
		if(checkMovies(date, location)){
			System.out.println("Retreiving movies from database..");
			System.out.println("Movie Name: Passengers Time: 3:00 P.M. User Rating: 3.5 Certification: PG 13");
			System.out.println("Movie Name: Assasin's Creed Time: 10:00 P.M. User Rating: 4.5 Certification: PG 13");
			System.out.println("Movie Name: Office Christmas Party Time: 3:00 P.M. User Rating: 3.0 Certification: R");
		}
		else
			System.out.println("No movies playing at this time at location"+location);
	
	}

	private boolean checkMovies(String date, String location) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean IMAXMakePayment(String custName, Double amount){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Please enter card details");
			String cardNumber = br.readLine();
			if(validateCard(custName, cardNumber)){
				System.out.println("Payment successful");
				return true;
			}
			else{
				System.out.println("Card declined. Please try again.");	
				return false;
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
			
	}

	private boolean validateCard(String custName, String cardNumber) {
		// TODO Auto-generated method stub
		return true;
	}

}
