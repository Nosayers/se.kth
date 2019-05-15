package se.kth.iv1350.pos.dbHandler;

public class CustumerRegistry {
	
	public float getCustomerDiscount(String customerID){
		float discount = 0;
		if(customerID.equals("1980-12-31-0000")) {
			discount = (float) 0.15;
		}
			return discount;
	}
	
}
