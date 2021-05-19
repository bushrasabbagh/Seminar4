package integration;

import model.Receipt;
import model.Sale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Amount;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PrinterTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @Before
    public void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void printReceipt() {
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        String itemNameAndIdentifier = "Paprika";
        ItemDTO itemDescription = new ItemDTO(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        sale.updateSale(item);
        Receipt receipt = new Receipt(sale);
        LocalDateTime saleTime = LocalDateTime.now();
        String expectedResult = "\n----------RECEIPT----------" +
                "\nSale time: " + saleTime.toLocalDate().toString() +
                "\nItems: " +
                "\nitem name: " + itemNameAndIdentifier + "\t" +
                "price: " + price + "\t" +
                "tax amount: " + tax + "\t" +
                " quantity: " + quantity + "\nTotal: " + price + "\nTax: " + tax + "\n" +
                "\n------------END------------\n\r\n";
        Printer printer = Printer.getPrinter();
        printer.printReceipt(receipt);
        String actualResult = outContent.toString();
        assertEquals("Output is not equal to string with the same state.", expectedResult, actualResult);
    }
}