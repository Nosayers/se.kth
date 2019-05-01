package se.kth.iv1350.pos.DTO;

import se.kth.iv1350.pos.dbHandler.Printer;
import se.kth.iv1350.pos.model.Sale;

public class Receipt {
	
	private String storeName = "Store";
	private String storeAdress = "Adress 22";
	private String dateAndTime = "2019-04-01 13:27";
	
	private Printer printer;
	public String receipt(Sale sale) {
		
		double totalPrice = sale.getTotalPrice(); 
		double amountPaid = sale.getAmoutPaid(); 
		double change = sale.getChange();
		ItemDTO [] allItems = sale.getAllItems();
		
		
		String receipt = "\n" +storeName+ "\n"+storeAdress+ "\n" +dateAndTime+ "\n";
		for (int i = 0; i < allItems.length; i++) {
			receipt = receipt + itemToString(allItems[i]);
		}
		receipt = receipt + ("\n Total Price: " +totalPrice+ "\n Amout paid: " +amountPaid+ "\n Amout back: "+change); 
		
		return receipt;
	}
	private String itemToString(ItemDTO item) {
		String itemAndPriceAsString = item.getName();
		itemAndPriceAsString += ("..................." + item.getPrice());
		return itemAndPriceAsString;
	}
	
	public void printReceipt (Sale sale) {
		String receipt = receipt(sale);
		printer.print(receipt);	
	}
	
}
