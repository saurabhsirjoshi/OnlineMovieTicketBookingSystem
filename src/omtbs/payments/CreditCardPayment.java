package omtbs.payments;

public class CreditCardPayment extends TicketPayment {

	public boolean payTickets(String[] paymentDetails, double Amount) {
		updateDefaultPaymentMethod(paymentDetails);
		if ((authentication(paymentDetails) == true) && conductTransaction(paymentDetails, Amount) == true)
		{
			System.out.println("Payment Successfully Completed");
			return true;
		}
		return false;

	}
	/*paymentDetails[0] = Type of payment CC, DC, PP
	 *paymentDetails[1] = Update To Default Method (Y/N) 
	 *paymentDetails[2] = CC Number
	 * paymentDetails[3] = CVV
	 * paymentDetails[4] = Exp
	 * paymentDetails[5] = Passowrd (IF Any)
	 * paymentDetails[6] = Bank Code
	 * paymentDetails[7] = Misc Details
	 */
	
	public boolean authentication(String[] paymentDetails) {
		// Authentication logic
		return true;

	}

	public boolean conductTransaction(String[] paymentDetails, double Amount) {
		// Transaction Logic
		return true;
	}
	
	public void updateDefaultPaymentMethod(String[] paymentDetails) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}