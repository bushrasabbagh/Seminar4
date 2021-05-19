package model;

import integration.Item;
import integration.ItemDTO;
import org.junit.Test;
import util.Amount;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ReceiptTest {

    @Test
    public void testToString() {
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
                        "\n------------END------------\n";
        String actualResult = receipt.toString();
        assertEquals("Receipt string is not equal to another instance with same state.", expectedResult, actualResult);
    }
}