package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbHandler.InventoryRegistry;

public class Sale {
	
	private String storeName = "Store";
	private String storeAdress = "Adress 22";
	private String dateAndTime = "2019-04-01 13:27"; 
	private double totalprice = 0; 
	private double amountPaid = 0; 
	private double change = 0;
	
	private ItemDTO [] allItems;
	private InventoryRegistry IventoryReg;
	private Controller contr;
	
	public Sale() {

	}
	
	public void View(Controller contr) {
		 this.contr = contr; 
	}
	
	public void addItem(ItemDTO itemSpecifications, int itemQuantity) {
		
		ItemDTO[] allI= new ItemDTO[this.allItems.length + 1];

		int  i = 0;
		for (i = 0; i < this.allItems.length; i++)
			allI[i] = this.allItems[i];
		
		allI[i] = itemSpecifications;
		this.allItems = allI;
		totalprice = totalprice + (itemSpecifications.getPrice() * itemQuantity);
	}

	public void updateTotalPrice(float discount) {
		if (discount != 0)
			totalprice = totalprice * (1 - discount);
		else 
			System.out.println ("No discount found");
	}
	public double getTotalPrice() {
		return totalprice;
	}

	public void inventoryUpdate() {
		for (int i = 0; i < this.allItems.length; i++)
			IventoryReg.inventoryUpdate(this.allItems[i]);
	}
	
}
