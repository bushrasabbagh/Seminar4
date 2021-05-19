package view;

import controller.Controller;
import controller.OperationFailedException;
import integration.InvalidItemIdentifierException;
import util.Amount;
import util.ConsoleLogHandler;
import util.LogHandler;

/**
 * This application does not have an "actual" view.
 * This class is a placeholder for a view that can make a sample execution
 */
public class View {
    private Controller controller;
    private ErrorMessageHandler errorMessageHandler = ErrorMessageHandler.getErrorMessageHandler();
    private LogHandler logHandler = ConsoleLogHandler.getLogHandler();

    /**
     *  Creates a new instance, represented as a view.
     * @param controller The class where all calls are being made.
     */
    public View(Controller controller){
        this.controller = controller;
        controller.addPaymentObserver(new TotalRevenueView());
    }

    /**
     *  Makes a sample execution of the application.
     *  AKA, simulating someone making inputs to the application.
     */
    public void sampleExecution(){
        String out;
        System.out.println("Cashier starts new sale.\n");
        controller.startNewSale();
        System.out.println("Cashier enter items. \n");
        //registerItem("Tomat", new Amount(1));
        registerItem("Gurka", new Amount(4));
        registerItem("Tomt", new Amount(5));
        registerItem("ERROR", new Amount(20));
        //registerItem("Paprika", new Amount(2));

        try{
            System.out.println("Cashier displays the total with taxes. \n");
            out = controller.displayTotalWithTax();
            System.out.println(out + "\n");
        }catch (IllegalStateException exc){
            handleException("Have to start new sale first.", exc);
        }

        try {
            System.out.println("Cashier enters the paid amount. \n");
            out = controller.pay(new Amount(2000));
            System.out.println(out);
        }catch (IllegalStateException exc){
            handleException("Have to start new sale first.", exc);
        }



    }

    private void registerItem(String itemIdentifier, Amount amount){
        String out;
        try {
            out = controller.registerItem(itemIdentifier, amount);
            System.out.println(out);
        }catch (InvalidItemIdentifierException exc) {
            handleException("Item identifier " + itemIdentifier +  " doesn't exist, please try again.", exc);
        }catch (OperationFailedException exc) {
            handleException("Failed to register item, try again.", exc);
        }catch (IllegalStateException exc){
            handleException("Have to start new sale.", exc);
        }
    }

    private void handleException(String message, Exception exception){
        errorMessageHandler.showErrorMsg(message);
        logHandler.showLogException(exception);
    }

}
