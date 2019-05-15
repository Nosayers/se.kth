package se.kth.iv1350.pos.dbHandler;

public class RegistryCreator {

	private ItemRegistry itemRegistry = new ItemRegistry();
	private CustumerRegistry customerReg = new CustumerRegistry();
	private InventoryRegistry inventoryReg = new InventoryRegistry();
	private AccountingRegistry accReg = new AccountingRegistry ();
	
	public ItemRegistry getItemRegistry() {
		return itemRegistry;
	}
	
	
}
