package se.kth.iv1350.pos.startup;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbHandler.RegistryCreator;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.dbHandler.Printer;

public class Main {
	
	/**  
	 * Startup, creates
	 **/
	
	public static void main(String[] args) {
		RegistryCreator creator = new RegistryCreator();
		Controller contr = new Controller(creator); 
		new View(contr).executions();
		Printer printer = new Printer(); 
	} 
	
}
