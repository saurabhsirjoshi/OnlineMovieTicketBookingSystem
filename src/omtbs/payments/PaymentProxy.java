package omtbs.payments;

public class PaymentProxy implements Payment {
	
	String[] paymentType;

	public PaymentProxy(String[] paymentType) {
		super();
		paymentType = paymentType;
	}

	@Override
	public boolean payTickets(String[] paymentDetails, double Amount) {
		// TODO Auto-generated method stub
		if (this.paymentType[0].equalsIgnoreCase("CC")) {
			TicketPayment t = new CreditCardPayment();
			t.payTickets(paymentDetails, Amount);
		}
		else if (this.paymentType[0].equalsIgnoreCase("DC")) {
			TicketPayment t = new DebitCardPayment();

			t.payTickets(paymentDetails, 335);
			t.payTickets(paymentDetails, Amount);
		}
		else if (this.paymentType[0].equalsIgnoreCase("PP")) {
			TicketPayment t = new PayPalPayment();
			t.payTickets(paymentDetails, Amount);
		}
		return false;
	}
	
	
}