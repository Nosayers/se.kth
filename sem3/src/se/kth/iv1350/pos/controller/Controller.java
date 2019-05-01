package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Discount;
import se.kth.iv1350.pos.dbHandler.RegistryCreator;
import se.kth.iv1350.pos.dbHandler.ItemRegistry;
import se.kth.iv1350.pos.DTO.ItemDTO;


/**
 * View calls all model classes through here.
 *
 */
public class Controller {
	private ItemRegistry itemReg;
	//private ItemDTO item;
	private Sale sale;
	private Discount dis;
	private CashRegister cashReg;

	/**
	 * Creates a new instance.
	//// *@registryCreator is used for all operation calls. 
	 */
	
	public Controller (RegistryCreator regCreator) {
		this.itemReg = regCreator.getItemRegistry();
	}
	
	//public Controller (ItemDTO item) {	this.item = item; }
	
	public void startNewSale(){
		sale = new Sale();
	}
	
	public String callAddItem(int itemIdentifier, int itemQuantity) {
		
		ItemDTO itemSpecification = itemReg.getItemSpecifications(itemIdentifier, itemQuantity);
		sale.addItem(itemSpecification, itemQuantity);
		
		if (itemSpecification != null) {
			String s = ("Name:" +itemSpecification.getName()+ "\nPrice:" +itemSpecification.getPrice()) ;
			return s;
		}
		else
			return "Item not found";
	}
	
	public void checksForDiscount(String customerID){
		float discount = dis.getDiscount(customerID);
		sale.updateTotalPrice(discount);
	}
	
	public double startPayment(String customerID) {
		checksForDiscount(customerID);
		cashReg.accountingUpdate(sale.getTotalPrice());
		sale.inventoryUpdate();
		return sale.getTotalPrice();
	}

	public double payment(double cash) {
		double change = sale.payment(cash);
		sale.receipt(sale);
		return change;
	}

	
}
