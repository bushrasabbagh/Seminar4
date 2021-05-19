package integration;

import util.Amount;

import java.util.Objects;

/**
 * Represents the data of an item.
 */
public class ItemDTO {
    private final Amount price;
    private final String itemName;
    private final Amount taxAmount;

    /**
     * Creates a new instance representing a particular item.
     *
     * @param price The price of the item.
     * @param itemName The name of the item.
     * @param taxAmount The tax amount of the item.
     */
    public ItemDTO(Amount price, String itemName, Amount taxAmount){
        this.price = price;
        this.itemName = itemName;
        this.taxAmount = taxAmount;
    }

    /**
     * Get value of price.
     *
     * @return the value of price.
     */
    public Amount getPrice() {
        return price;
    }

    /**
     * Get the value of itemName.
     *
     * @return the value of itemName.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Get the value of taxAmount.
     *
     * @return the value of taxAmount.
     */
    public Amount getTaxAmount() {
        return taxAmount;
    }

    /**
     * Turns the instance into a <code>String</code>.
     *
     * @return The instance as a <code>String</code>.
     */
    @Override
    public String toString() {
        String builder = "item name: " + itemName + "\t" +
                "price: " + price + "\t" +
                "tax amount: " + taxAmount + "\t";
        return builder;
    }

    /**
     * Two <code>ItemDTO</code> instances are equal if all fields are equal.
     *
     * @param obj The <code>ItemDTO</code> to compare with this <code>ItemDTO</code>.
     * @return <code>true</code> if all fields in the specified <code>ItemDTO</code> are equal to
     *         corresponding fields in this <code>ItemDTO</code>, <code>false</code> if they are not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final ItemDTO other = (ItemDTO) obj;
        if (!Objects.equals(this.price, other.price)){
            return false;
        }
        if (!this.itemName.equals(other.itemName)){
            return false;
        }
        if (!Objects.equals(this.taxAmount, other.taxAmount)){
            return false;
        }
        return true;
    }
}
