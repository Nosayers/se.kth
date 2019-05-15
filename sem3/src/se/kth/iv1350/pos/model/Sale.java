package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.Receipt;
import se.kth.iv1350.pos.dbHandler.InventoryRegistry;
import java.util.ArrayList;

public class Sale {
	 
	private double totalPrice = 0; 
	private double amountPaid = 0; 
	private double change = 0;
	private ArrayList<ItemDTO> allItems = new ArrayList<>();
	
	private InventoryRegistry IventoryReg;
	private Receipt receipt;
	
	public Sale() {
		InventoryRegistry IventoryReg = new InventoryRegistry();
		this.IventoryReg = IventoryReg;
		Receipt receipt = new Receipt();
		this.receipt = receipt;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public double getAmoutPaid() {
		return amountPaid;
	}
	
	public double getChange() {
		return change;
	}
	public ArrayList<ItemDTO> getAllItems() {
		return (allItems);
	}
	
	public void addItem(ItemDTO itemSpecifications, int itemQuantity) {	
		allItems.add(itemSpecifications);
		totalPrice = totalPrice + (itemSpecifications.getPrice() * itemQuantity);
	}

	public void updateTotalPrice(float discount) {
		if (discount != 0)
			totalPrice = totalPrice * (1 - discount);
		else 
			System.out.println ("No discount found");
	}

	public void inventoryUpdate() {
		for (int i = 0; i < allItems.size(); i++)
			IventoryReg.inventoryUpdate(allItems.get(i));
	}

	public double payment(double cash) {
		amountPaid = cash;
		change = (amountPaid - totalPrice);
		return change;
	}
	public void receipt(Sale sale) {
		receipt.printReceipt(sale);
	}
}
