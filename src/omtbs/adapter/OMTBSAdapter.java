package omtbs.adapter;

public abstract class OMTBSAdapter {

	public abstract boolean bookTickets(String custName, String movie, String dateTime, String location);
	public abstract void getHistory(String custName);
	public abstract void searchMovies(String date, String location);
	public abstract boolean payTicket(String custName, Double amount);
}
