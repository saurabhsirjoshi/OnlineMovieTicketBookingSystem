package omtbs.payments;

public class DebitCardPayment extends TicketPayment {

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
	 * paymentDetails[1] = Update To Default Method (Y/N) 
	 * paymentDetails[2] = DC Number
	 * paymentDetails[3] = CVV
	 * paymentDetails[4] = Exp
	 * paymentDetails[5] = Passowrd (IF Any)
	 * paymentDetails[6] = Bank Code
	 * paymentDetails[7] = Misc Details
	 */
	
	public boolean authentication(String[] paymentDetails) {
		// Authentication logic
		if ((paymentDetails[2].length() > 16) || (paymentDetails[2].length() < 16)) {
			System.out.println("invalid credit card number");
		}
		
		if ((paymentDetails[3].length() > 3) || (paymentDetails[3].length() < 3)) {
			System.out.println("invalid credit card number");
		}
		
		if (paymentDetails[4].matches("\\d{4}-\\d{2}-\\d{2}")) {
		    
		}
		else{
			System.out.println("incorrect date format");
		}
		return true;

	}

	public boolean conductTransaction(String[] paymentDetails, double Amount) {
		// Transaction Logic
		System.out.println("Transaction completed");
		return true;
	}
	
	public void receiveconfirmation() 
	{
		System.out.println("Card payment confirmed");
	}
	
	public void updateDefaultPaymentMethod(String[] paymentDetails) {
		// TODO Auto-generated method stub
		
	}

}