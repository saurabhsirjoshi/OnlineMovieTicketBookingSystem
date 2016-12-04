package omtbs.payments;

public class CreditCardPayment extends TicketPayment {

	public CreditCardPayment(String fileName) {

		// TODO Auto-generated constructor stub
	}

	public boolean payTickets(String creditcarddetails, double Amount) {
		if ((authentication("Hello") == true) && conductTransaction("kasjk", 10290) == true)

			return true;
		return false;

	}

	public boolean authentication(String aks) {
		return true;
	}

	public boolean conductTransaction(String creditcarddetails, double Amount) {
		return true;
	}
}