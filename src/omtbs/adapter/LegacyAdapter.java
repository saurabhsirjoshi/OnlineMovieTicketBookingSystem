package omtbs.adapter;

public class LegacyAdapter extends OMTBSAdapter {
private LegacySystem myLegacy;
	
	public LegacyAdapter(){
		myLegacy = new LegacySystem();
	}
	
	public boolean bookTickets(String custName, String movie, String dateTime, String location){
		boolean result = myLegacy.bookSeats(custName, movie, dateTime, location);
		return result;
	}
	
	public void getHistory(String custName){
		myLegacy.getBookingHist(custName);
	}
	
	public void searchMovies(String date, String location){
		myLegacy.searchMovies(date, location);
	}
	
	public boolean payTicket(String custName, Double amount){
		boolean result = myLegacy.makePayment(custName, amount);
		return result;
	}

}
