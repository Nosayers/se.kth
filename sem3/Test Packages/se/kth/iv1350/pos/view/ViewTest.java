package se.kth.iv1350.pos.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.controller.Controller;

class ViewTest {
	/**  
	 * Puts the programs printout 
	 * and puts it in Buffet in memory
	 * PrintStream saves the original system OutPrint
	 * so that it can be restored after test program
	 **/
	private View instance; 
	ByteArrayOutputStream printout;
	PrintStream originalprintout;
	
	@BeforeEach
	void setUp() {
		Controller contr = new Controller();
		instance = new View(contr);
		
		printout = new ByteArrayOutputStream ();
		PrintStream inMemoSysOutprint = new PrintStream (printout);
		originalprintout = System.out;
		System.setOut(inMemoSysOutprint);
		
	}

	@AfterEach
	void tearDown() {
		System.setOut(originalprintout);
		printout = null;

	}

	@Test
	public void testExecutions() {
		//System.out.println ("StartNewSale");
		
		instance.executions();
		String result = printout.toString();
		String expectedResult = "New sale";
		assertTrue(result.contains(expectedResult), "Wrong printout after executions( ran).");
	}
	
	@Test
	public void testFindItemToAdd() {
//		//System.out.println ("findItemToAdd");
//		
//		Object itemIdentifier = null;
//		Object itemQuantity = null;
//		
//		instance.executions();
//		String result = printout.callAddItem(itemIdentifier, itemQuantity);
//		String expectedResult = "New sale";
//		assertTrue(result.contains(expectedResult), "Wrong printout after executions( ran).");
	}
	
	/*
	 	int itemIdentifiers [] = {1,2,3,4};
		int itemQuantity [] = {1,3,2,1};
		System.out.println ("AddItemToSale");
	
		instance.startNewSale();
		String result = printout.toString();
		String expectedResult = "Sale";
		assertTrue(result.contains(expectedResult), "Wrong printout after executions() run.");
	*/
}
