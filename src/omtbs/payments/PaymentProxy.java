package omtbs.payments;

public class PaymentProxy implements Payment {
	
	String paymentType;

	public PaymentProxy(String paymentType) {
		super();
		paymentType = paymentType;
	}

	@Override
	public boolean payTickets(String paymentDetails, double Amount) {
		// TODO Auto-generated method stub
		if (this.paymentType.equalsIgnoreCase("CC")) {
			TicketPayment t = new CreditCardPayment();
			t.payTickets(paymentDetails, 335);
		}
		else if (this.paymentType.equalsIgnoreCase("DC")) {
			TicketPayment t = new DebitCardPayment();
			t.payTickets("24231351", 335);
		}
		
		return false;
	}
	
	
}
