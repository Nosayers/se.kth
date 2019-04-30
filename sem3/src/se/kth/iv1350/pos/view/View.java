package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.controller.Controller;
//import se.kth.iv1350.pos.DTO.ItemDTO;

/** 
 * This program has no view, 
 * instead, this class contains one single class, View
 * which contains hard-coded calls to the controller
 **/
public class View {
	
	/**
	 *Since there is no input, the inputs are 
	 *manually added in View
	 */
	int itemIdentifiers [] = {1,2,3,4};
	int itemQuantity [] = {1,3,2,1};

	String customerID = "1980-12-31-0000"; //the customers personal number
	double cash = 100; //the amount the customer pays with
	
	private Controller contr;
	
	/**  
	 * Creates a new instance.
	 * @param contr is used for all operations. 
	 **/
	
	 public View(Controller contr) {
		 this.contr = contr; 
	}
	
	 /**  
	  * Calls all system operations. 
	  * Loops though all the items (they are being scanned)  
	  **/ 
	 public void executions() {
		contr.startNewSale();
		
		for (int i = 0; i < itemIdentifiers.length; i++) {
			String displayScanningMessage = contr.callAddItem(itemIdentifiers[i], itemQuantity[i]);
			System.out.println (displayScanningMessage);
		}
		
		double totalPriceBeforeDiscount = contr.startPayment(cash);
		System.out.println ("Total Price:" + totalPriceBeforeDiscount);
		
		double totalPrice = contr.checksForDiscount(customerID);
		System.out.println ("Total Price:" + totalPrice);
		
		
	 }
}
