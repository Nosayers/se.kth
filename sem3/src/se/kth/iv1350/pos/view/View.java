package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.DTO.ItemDTO;
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
		System.out.println ("New sale\n");
	 
		for (int i = 0; i < itemIdentifiers.length; i++) {
			ItemDTO item = contr.callAddItem(itemIdentifiers[i], itemQuantity[i]);
			String displayScanningMessage = ("Name:" +contr.getName(item)+ "\nPrice:" +contr.getPrice(item)+ "\n") ;
			System.out.println (displayScanningMessage);
		}
		
		double totalPrice = contr.startPayment(customerID);
		System.out.println ("Total Price:" + totalPrice);
	 
		double change = contr.payment(cash);
		System.out.println ("Money paid: " + cash);
		System.out.println ("Money back: " + change);
	 }
}
