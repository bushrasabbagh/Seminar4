package integration;

import model.Sale;
import util.Amount;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A dummy representing a class that makes calls to a "external inventory system"
 */
public class InventorySystem {
    private HashMap<String, Item> inventory = new HashMap();

    /**
     * Creates a new instance of a dummy inventory system.
     */
    InventorySystem(){
        addItems();
    }

    /**
     * Updates the amount of items in the inventory.
     *
     * @param sale The information about the sale, contains information about the items.
     */
    public void updateInventory(Sale sale){
        HashMap<String, Item> items = sale.getItems();
        Set entries = items.entrySet();

        for (Object entry : entries) {
            Item item = getCurrentItem(entry);

            if (itemExistsInInventory(item)) {
                decreaseQuantityOfItem(item);
            }
        }
    }

    private boolean itemExistsInInventory(Item item){
        return inventory.containsKey(item.getItemIdentifier());
    }

    private void decreaseQuantityOfItem(Item item){
        Item oldItem = inventory.get(item.getItemIdentifier());
        oldItem.decreaseQuantity(item.getQuantity());
        inventory.put(oldItem.getItemIdentifier(), oldItem);
    }

    private Item getCurrentItem(Object entry){
        Map.Entry mapping = (Map.Entry) entry;
        return (Item) mapping.getValue();
    }

    private void addItems(){
        inventory.put("Tomat", new Item(new ItemDTO(new Amount(20), "Tomat", new Amount(10)), "Tomat", new Amount(Integer.MAX_VALUE)));
        inventory.put("Gurka", new Item(new ItemDTO(new Amount(30), "Gurka", new Amount(15)), "Gurka", new Amount(Integer.MAX_VALUE)));
        inventory.put("Apelsin", new Item(new ItemDTO(new Amount(42), "Apelsin", new Amount(20)), "Apelsin", new Amount(Integer.MAX_VALUE)));
        inventory.put("Paprika", new Item(new ItemDTO(new Amount(5), "Paprika", new Amount(2)), "Paprika", new Amount(Integer.MAX_VALUE)));
    }
}
