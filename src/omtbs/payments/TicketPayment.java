package omtbs.payments;

public abstract class TicketPayment implements Payment {

	public abstract boolean payTickets(String paymentDetails, double Amount);

}
