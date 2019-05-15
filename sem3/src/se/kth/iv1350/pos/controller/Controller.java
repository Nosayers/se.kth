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
	 *@registryCreator is used for all operation calls. 
	 */
	
	public Controller (RegistryCreator regCreator) {
		this.itemReg = regCreator.getItemRegistry();
		Discount dis = new Discount();
		this.dis = dis;

		CashRegister cashReg = new CashRegister();
		this.cashReg = cashReg;
	}
	
	public Controller () {	
		
	}
	
	public void startNewSale(){
		sale = new Sale();
	}
	
	public ItemDTO callAddItem(int itemIdentifier, int itemQuantity) {
		
		ItemDTO item = itemReg.getItemSpecifications(itemIdentifier, itemQuantity);
		sale.addItem(item, itemQuantity);
			
		return item;
	}
	
	public void checksForDiscount(String customerID){
		float discount = dis.getDiscount(customerID);
		sale.updateTotalPrice(discount);
		//System.out.println ("Discount: " +discount);
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

	/**
	 *  "Get"- functions for View
	 *  makes it possible in View 
	 *  to get information that Sale holds
	 */
	public double getPrice(ItemDTO item) {
		return item.getPrice();
	}

	public String getName (ItemDTO item) 
	{
		return item.getName();
	}
	
}
