package integration;

/**
 * A object that initiates the systems needed for the application,
 * accounting system and inventory system.
 * Created as a singleton.
 */
public class SystemCreator {
    private static final SystemCreator SYSTEM_CREATOR = new SystemCreator();
    private AccountingSystem accountingSystem = new AccountingSystem();
    private InventorySystem inventorySystem = new InventorySystem();


    private SystemCreator(){
    }

    /**
     * Gets the singleton instance of <code>SystemCreator</code>
     * @return the <code>SystemCreator</code>
     */
    public static SystemCreator getSystemCreator(){
        return SYSTEM_CREATOR;
    }

    /**
     * Gets the value of accountingSystem.
     *
     * @return The value of accountingSystem.
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Gets the value of inventorySystem.
     *
     * @return The value of inventorySystem.
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }
}
