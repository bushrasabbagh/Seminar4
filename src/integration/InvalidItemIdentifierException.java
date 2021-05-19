package integration;

/**
 * Thrown when trying to get an item that doesn't exist.
 */
public class InvalidItemIdentifierException extends Exception {
    String itemIdentifier;

    /**
     * Creates a new instance specifying which item identifier that didn't exist.
     *
     * @param itemIdentifier The item identifier that doesn't exists.
     */
    public InvalidItemIdentifierException(String itemIdentifier){
        super("Given item identifer: " + itemIdentifier + ", doesn't exist.");
        this.itemIdentifier = itemIdentifier;
    }

    /**
     * Gets the item identifier that doesn't exist.
     *
     * @return The item identifier that doesn't exists.
     */
    public String getItemIdentiferThatDoesntExist(){
        return itemIdentifier;
    }
}
