package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbHandler.AccountingRegistry;

public class CashRegister {
	private AccountingRegistry accReg;
	
	public void accountingUpdate(double updatedTotalPrice) {
		AccountingRegistry accReg = new AccountingRegistry();
		this.accReg = accReg;
		accReg.accoutingUpdate(updatedTotalPrice);
	}

}
