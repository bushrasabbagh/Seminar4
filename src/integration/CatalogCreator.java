package integration;

/**
 * Represents a creator that consists of different catalogs.
 * Created as a singleton.
 */
public class CatalogCreator {
    private static final CatalogCreator CATALOG_CREATOR = new CatalogCreator();
    private DiscountCatalog discountCatalog = new DiscountCatalog();
    private ItemCatalog itemCatalog = new ItemCatalog();

    private CatalogCreator(){
    }

    /**
     * Gets the singleton instance of <code>CatalogCreator</code>
     * @return The <code>CatalogCreator</code>
     */
    public static CatalogCreator getCatalogCreator(){
        return CATALOG_CREATOR;
    }

    /**
     * Gets the value of discountCatalog.
     *
     * @return The value discountCatalog.
     */
    public DiscountCatalog getDiscountCatalog() {
        return discountCatalog;
    }

    /**
     * Gets the value of itemCatalog.
     * @return  The value of itemCatalog.
     */
    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }
}
