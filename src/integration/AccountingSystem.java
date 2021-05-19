package integration;

import model.Sale;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Represents an external dummy accounting system
 */
public class AccountingSystem {
    private HashMap<LocalDateTime, Sale> accounting = new HashMap();

    /**
     *  Creates a new instance, representing a dummy accounting system.
     */
    AccountingSystem(){ }

    /**
     * Adds the sale to the book keeping. Adds the time when the sale was finished to the book keeping.
     *
     * @param sale The finished sale that will be added to the book keeping.
     */
    public void bookKeep(Sale sale){
        LocalDateTime saleTime = LocalDateTime.now();
        accounting.put(saleTime, sale);
    }
}
