package model;

import integration.Item;
import util.Amount;

/**
 *  Represents the total amount with tax.
 */
public class Total {
    private Amount total;
    private Amount totalTax;

    /**
     *  Creates a new instance, representing the total.
     */
    public Total(){
        this.total = new Amount(0);
        this.totalTax = new Amount(0);
    }

    /**
     * Gets the value of total.
     *
     * @return The value of total.
     */
    public Amount getTotal() {
        return total;
    }

    /**
     * Gets the value the totalTax.
     *
     * @return The totalTax.
     */
    public Amount getTotalTax() {
        return totalTax;
    }

    /**
     *  Adds the tax to the total and returns it as a new {@link Amount}
     *
     * @return The total with taxes.
     */
    public Amount getTotalWithTax(){
        return total.plus(totalTax);
    }

    /**
     *  Updates the total and the totalTax. By adding the items price to the total, and the items tax to the total tax.
     *
     * @param item The item that will be added to the total, have information about how many items there are and the price and tax.
     */
    public void updateTotal(Item item){
        if(item == null){
            return;
        }
        Amount amountOfItems = item.getQuantity();
        Amount itemPrice = item.getItemDescription().getPrice();
        Amount itemTax = item.getItemDescription().getTaxAmount();

        this.totalTax = this.totalTax.plus(amountOfItems.multiply(itemTax));
        this.total = this.total.plus(amountOfItems.multiply(itemPrice));
    }

    /**
     * Updates the total and the totalTax. By adding it with another total.
     *
     * @param total The total that will be added to this total.
     */
    public void updateTotal(Total total){
        this.total = this.total.plus(total.getTotal());
        this.totalTax = this.totalTax.plus(total.getTotalTax());
    }
}
