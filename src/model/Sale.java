package model;

import integration.Item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Represents a point of sale between a customer and a cashier.
 */
public class Sale {
    private Total total;
    private HashMap<String, Item> items = new HashMap<>();

    /**
     * Creates a new instance, represented as a Sale.
     */
    public Sale(){
        this.total = new Total();
    }

    /**
     * Gets the value of total.
     *
     * @return The value of total.
     */
    public Total getTotal() {
        return total;
    }

    /**
     * Gets the HashMap items.
     *
     * @return The HashMap items.
     */
    public HashMap<String, Item> getItems(){
        return items;
    }

    /**
     * Updates the current sale. Updates how many items and the running total.
     * Can't take null items.
     *
     * @param item The item that will be added to the sale.
     * @return  The itemDescription as a string.
     */
    public String updateSale(Item item){
        if (itemListContains(item)) {
            updateItemQuantityAndTotal(item);
        } else {
            addItemAndUpdateTotal(item);
        }
        return item.getItemDescription().toString();
    }

    private boolean itemListContains(Item item){
        return items.containsKey(item.getItemIdentifier());
    }

    private void updateItemQuantityAndTotal(Item item){
        Item oldItem = items.get(item.getItemIdentifier());
        oldItem.increaseQuantity(item.getQuantity());
        items.put(oldItem.getItemIdentifier(), oldItem);
        total.updateTotal(item);
    }

    private void addItemAndUpdateTotal(Item item){
        items.put(item.getItemIdentifier(), item);
        total.updateTotal(item);
    }

    /**
     * Makes the instance into to a <code>String</code>
     *
     * @return The instance as a <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();
        if (items.size() == 0){
            addNewLine(builder, "No items");
        }
        while(entriesIterator.hasNext()) {
            Item item = getCurrentItem(entriesIterator);
            builder.append(item.getItemDescription().toString());
            addNewLine(builder, " quantity: " + item.getQuantity().toString());
        }

        addNewLine(builder, "Total: " + total.getTotal().toString());
        addNewLine(builder, "Tax: " + total.getTotalTax());

        return builder.toString();
    }

    private Iterator getEntries(){
        Set entries = items.entrySet();
        return entries.iterator();
    }

    private Item getCurrentItem(Iterator entriesIterator){
        Map.Entry mapping = (Map.Entry) entriesIterator.next();
        return (Item) mapping.getValue();
    }

    private void addNewLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }
}
