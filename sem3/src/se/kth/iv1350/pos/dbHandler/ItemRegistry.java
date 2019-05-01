package se.kth.iv1350.pos.dbHandler;
import se.kth.iv1350.pos.DTO.ItemDTO;

public class ItemRegistry {
		
	ItemDTO item1 = new ItemDTO(1, 12, "Apple", 12);
	ItemDTO item2 = new ItemDTO(2, 6, "Soup", 9);			
	ItemDTO item3 = new ItemDTO(3, 12, "Ramen", 8);
	ItemDTO item4 = new ItemDTO(4, 25, "Gum", 10);
		
	public ItemRegistry(){	
	}
	
	public ItemDTO getItemSpecifications (int itemIdentifier,int itemQuantity){
		ItemDTO item = getItemInfo(itemIdentifier);
		item.setItemQuantity(itemQuantity);
		return item;
	}
	
	public ItemDTO getItemInfo(int itemID) {
		ItemDTO item = null;
		switch (itemID) {
		case 1:
			item = item1;
			break;
		case 2:
			item = item2;
			break;
		case 3:
			item = item3;
			break;
		case 4:
			item = item4;
			break;
		}
		return item;
	}
}
