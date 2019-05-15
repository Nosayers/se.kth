package se.kth.iv1350.pos.DTO;

import java.util.ArrayList;

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
		ArrayList<ItemDTO> allItems = sale.getAllItems();
		
		Printer printer = new Printer();
		this.printer = printer;
		
		
		String receipt = "\n" +storeName+ "\n"+storeAdress+ "\n" +dateAndTime+ "\n";
		for (int i = 0; i < allItems.size(); i++) {
			receipt = receipt + itemToString(allItems.get(i));
		}
		receipt = receipt + ("\nTotal Price: " +totalPrice+ "\nAmout paid: " +amountPaid+ "\nAmout back: "+change); 
		
		return receipt;
	}
	private String itemToString(ItemDTO item) {
		String itemAndPriceAsString = ("\n"+item.getName()+"\t..................." + item.getPrice());
		return itemAndPriceAsString;
	}
	
	public void printReceipt (Sale sale) {
		String receipt = receipt(sale);
		printer.print(receipt);	
	}
	
}
