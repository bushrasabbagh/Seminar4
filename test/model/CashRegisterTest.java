package model;

import integration.Item;
import integration.ItemDTO;
import org.junit.Test;
import util.Amount;

import static org.junit.Assert.*;

public class CashRegisterTest {

    @Test
    public void testAddPayment() {
        CashRegister cashRegister = new CashRegister();
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        String itemNameAndIdentifier = "Paprika";
        ItemDTO itemDescription = new ItemDTO(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(2);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Total total = new Total();
        total.updateTotal(item);
        Amount paidAmount = new Amount(100);
        Payment payment = new Payment(paidAmount, total);
        cashRegister.addPayment(payment);
        Amount expectedResult = new Amount(0).plus(payment.getTotal().getTotalWithTax());
        Amount actualResult = cashRegister.getBalance();
        assertEquals("The balance is not the same as another instance with the same state.", expectedResult, actualResult);
    }
}