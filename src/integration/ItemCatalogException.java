package integration;

/**
 * Thrown when something goes wrong while performing operations in <code>ItemCatalog</code>
 */
public class ItemCatalogException extends RuntimeException {

    /**
     * Creates a new instance representing the condition described in the specified message.
     *
     * @param message A message that describes what went wrong.
     */
    public ItemCatalogException(String message){
        super(message);
    }

}
