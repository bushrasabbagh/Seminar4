package startup;

import controller.Controller;
import integration.CatalogCreator;
import integration.Printer;
import integration.SystemCreator;
import view.View;

/**
 * Contains the <code>main</code> method.
 * Performs all startup of the application.
 */
public class Main {

    /**
     * Starts the application.
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        SystemCreator systemCreator = SystemCreator.getSystemCreator();
        CatalogCreator catalogCreator = CatalogCreator.getCatalogCreator();
        Printer printer = Printer.getPrinter();
        Controller controller = new Controller(systemCreator, catalogCreator, printer);
        View view = new View(controller);
        view.sampleExecution();
    }
}
