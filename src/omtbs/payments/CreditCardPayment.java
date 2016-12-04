package omtbs.payments;

public class CreditCardPayment extends TicketPayment {

	public boolean payTickets(String creditcarddetails, double Amount) {
		if ((authentication("Hello") == true) && conductTransaction("kasjk", 10290) == true)

			return true;
		return false;

	}

	public boolean authentication(String aks) {
		// Authentication logic
		return true;

	}

	public boolean conductTransaction(String creditcarddetails, double Amount) {
		// Transaction Logic
		return true;
	}
}