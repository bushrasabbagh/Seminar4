package integration;

import model.Receipt;

/**
 * Represents a printer.
 * Created as a singleton.
 */
public class Printer {
    private static final Printer PRINTER = new Printer();


    private Printer(){ }

    /**
     * Gets the singleton instance of <code>Printer</code>
     * @return The <code>Printer</code>
     */
    public static Printer getPrinter(){
        return PRINTER;
    }

    /**
     * Prints the specified receipt, this is a dummy printer and not a real one.
     * It prints to <code>System.out</code>, instead of a printer.
     *
     * @param receipt The specified receipt that will be printed.
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
