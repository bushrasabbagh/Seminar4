package controller;

import integration.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Amount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ControllerTest {
    private Controller controller;


    @Before
    public void setUp() {
        controller = new Controller(SystemCreator.getSystemCreator(), CatalogCreator.getCatalogCreator(), Printer.getPrinter());
    }

    @After
    public void tearDown() {
        controller = null;
    }

    @Test
    public void registerItem() {
        controller.startNewSale();
        String itemName = "Tomat";
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        try {
            String actualResult = controller.registerItem(itemName, new Amount(1));
            String expectedResult = "item name: " + itemName + "\t" +
                    "price: " + price + "\t" +
                    "tax amount: " + taxAmount + "\t" +
                    ", quantity: " + new Amount(1) + ", running total: " + price;
            assertEquals("String from registerItem is not the same as String with the same state.", expectedResult, actualResult);
        }catch (InvalidItemIdentifierException | ServerNotRunningException | OperationFailedException exc){
        }


    }

    @Test
    public void registerItemDataBaseFAIL() {
        controller.startNewSale();
        String itemName = "DATABASEERROR";
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        try {
            String actualResult = controller.registerItem(itemName, new Amount(1));
            String expectedResult = "item name: " + itemName + "\t" +
                    "price: " + price + "\t" +
                    "tax amount: " + taxAmount + "\t" +
                    ", quantity: " + new Amount(1) + ", running total: " + price;
            //assertEquals("String from registerItem is not the same as String with the same state.", expectedResult, actualResult);
            fail("Database Error");
        }catch (InvalidItemIdentifierException | ServerNotRunningException | OperationFailedException exc){
            assertTrue(exc.getMessage().contains("server"));

            //fail("Item registration failed. Got exception.");
        }
    }


    @Test
    public void registerItemNotFound() {
        controller.startNewSale();
        String itemName = "testItem";
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        try {
            String actualResult = controller.registerItem(itemName, new Amount(1));
            String expectedResult = "item name: " + itemName + "\t" +
                    "price: " + price + "\t" +
                    "tax amount: " + taxAmount + "\t" +
                    ", quantity: " + new Amount(1) + ", running total: " + price;
            //assertEquals("String from registerItem is not the same as String with the same state.", expectedResult, actualResult);
            fail("Not found");
        }catch (InvalidItemIdentifierException | ServerNotRunningException | OperationFailedException exc){
            assertTrue(exc.getMessage().contains("doesn't exist"));
        }
    }

    @Test
    public void registerItemOperationFailed() {
        controller.startNewSale();
        String itemName = "ERROR";
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        try {
            String actualResult = controller.registerItem(itemName, new Amount(1));
            String expectedResult = "item name: " + itemName + "\t" +
                    "price: " + price + "\t" +
                    "tax amount: " + taxAmount + "\t" +
                    ", quantity: " + new Amount(1) + ", running total: " + price;
            //assertEquals("String from registerItem is not the same as String with the same state.", expectedResult, actualResult);
            fail("Failed");
        }catch (InvalidItemIdentifierException | ServerNotRunningException | OperationFailedException exc){
            assertTrue(exc.getMessage().contains("Could not get the item"));
        }
    }


    @Test
    public void displayTotalWithTax() {
        controller.startNewSale();
        String itemName = "Tomat";
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        try {
            controller.registerItem(itemName, new Amount(1));
        }catch (OperationFailedException exc){

        }catch (InvalidItemIdentifierException exc){

        }

        String actualResult = controller.displayTotalWithTax();
        String expectedResult = "total with taxes: " + price.plus(taxAmount);
        assertEquals("The total with tax from sale is not equal to the expected result.", expectedResult, actualResult);
    }

    @Test
    public void pay() {
        controller.startNewSale();
        String itemName = "Tomat";
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        try {
            controller.registerItem(itemName, new Amount(1));
        }catch (OperationFailedException exc){

        }catch (InvalidItemIdentifierException exc){

        }
        Amount paidAmount = new Amount(40);
        String expectedResult = "Change: " + paidAmount.minus(price.plus(taxAmount));
        String actualResult = controller.pay(paidAmount);
        assertEquals("Change is not equal to amount with the same amount.", expectedResult, actualResult);
    }

}