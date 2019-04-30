package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.Sale;
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

	/**
	 * Creates a new instance.
	//// *@registryCreator is used for all operation calls. 
	 */
	
	public Controller (RegistryCreator regCreator) {
		this.itemReg = regCreator.getItemRegistry();
	}
	
	//public Controller (ItemDTO item) {	this.item = item; }
	
	public void startNewSale(){
		Sale sale = new Sale();
	}
	
	public String callAddItem(int itemIdentifier, int itemQuantity) {
		
		ItemDTO itemSpecification = itemReg.getItemSpecifications(itemIdentifier, itemQuantity);
		sale.addItem(itemSpecification, itemQuantity);
		
		if (itemSpecification != null) {
			String s = ("Name:" +itemSpecification.getName()+ "/n Price:" +itemSpecification.getPrice()) ;
			return s;
		}
		else
			return "Item not found";
	}
	
	public double checksForDiscount(String customerID){
		float discount = dis.getDiscount(customerID);
		sale.updateTotalPrice(discount);
		return sale.getTotalPrice();
	}
	
	public double startPayment(double cash) {
		sale.inventoryUpdate();
		return sale.getTotalPrice();
	}

	
}
