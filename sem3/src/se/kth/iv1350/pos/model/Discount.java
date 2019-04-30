package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.dbHandler.CustumerRegistry;

public class Discount {

	private CustumerRegistry cuReg;
	
	public Discount (CustumerRegistry cuReg) {
		 this.cuReg = cuReg; 
	}
	
	public float getDiscount(String customerID) {	
	float discount = cuReg.getCustomerDiscount(customerID);
	return discount;
	}
}
