package controller;

import integration.CatalogCreator;
import integration.InvalidItemIdentifierException;
import integration.Printer;
import integration.SystemCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Amount;

import static org.junit.Assert.*;

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
        }catch (OperationFailedException exc){

        }catch (InvalidItemIdentifierException exc){

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