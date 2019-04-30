package se.kth.iv1350.pos.DTO;

public class ItemDTO {

	private int itemIdentifier;
	private String itemName;
	private double itemPrice;//vat included
	private float itemVAT;
	private int itemQuantity;

	public ItemDTO () {
			
	}
		
	public ItemDTO (int itemId, float vat, String name, double price) {
			this.itemIdentifier = itemId;
			this.itemName = name;
			this.itemPrice = price;
			this.itemVAT = vat;
	}
	public String getName() {
			return itemName;	
	}
		
	public double getPrice() {
		return itemPrice;
	}
	
	public void setItemQuantity(int quantity) {
		this.itemQuantity = quantity;
	}


}
