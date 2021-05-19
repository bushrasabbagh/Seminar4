package integration;

import util.CustomerIdentification;
import util.DiscountRule;

import java.util.HashMap;

/**
 * Represents the discount database.
 */
public class DiscountCatalog {
    private HashMap<CustomerIdentification, DiscountRule> discounts = new HashMap<>();
    private final double NO_DISCOUNT_RATE = 1.0;


    /**
     *  Creates a new instance, represented as a discount database.
     */
    DiscountCatalog(){
        addCustomerAndTheirDiscounts();
    }

    /**
     * Checks if the customer has a discount.
     *
     * @param ID The identification of the customer.
     * @return If the customer exists in database we return it's discount, if it does not we return <code>NO_DISCOUNT_RATE</code>
     * which means the customer does not have a discount
     */
    public DiscountRule lookForDiscount(CustomerIdentification ID){
        if (discounts.containsKey(ID)){
            return discounts.get(ID);
        }
        return new DiscountRule(NO_DISCOUNT_RATE);
    }

    private void addCustomerAndTheirDiscounts(){
        discounts.put(new CustomerIdentification("9312209438"), new DiscountRule(0.4));
        discounts.put(new CustomerIdentification("8304102472"), new DiscountRule(0.6));
    }
}
