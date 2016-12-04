package omtbs.adapter;

public class IMAXAdapter extends OMTBSAdapter {
	private IMAXSystem myIMAX;
	
	public IMAXAdapter(){
		myIMAX = new IMAXSystem();
	}
	
	public boolean bookTickets(String custName, String movie, String dateTime, String location){
		boolean result = myIMAX.IMAXBookTicket(custName, movie, dateTime, location);
		return result;
	}
	
	public void getHistory(String custName){
		myIMAX.IMAXGetHistory(custName);
	}
	
	public void searchMovies(String date, String location){
		myIMAX.IMAXSrchMovies(date, location);
	}
	
	public boolean payTicket(String custName, Double amount){
		boolean result = myIMAX.IMAXMakePayment(custName, amount);
		return result;
	}

}
