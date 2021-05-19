package view;

import java.time.LocalDateTime;

/**
 * Takes care of the error messages for the user interface.
 */
public class ErrorMessageHandler {
    private static final ErrorMessageHandler ERROR_MESSAGE_HANDLER = new ErrorMessageHandler();
    private final String NEW_LINE = "\n";

    private ErrorMessageHandler(){}

    /**
     * Gets the singleton instance of <code>ErrorMessageHandler</code>
     * @return
     */
    public static ErrorMessageHandler getErrorMessageHandler(){
        return ERROR_MESSAGE_HANDLER;
    }

    /**
     * Prints out a message to the user interface.
     * The printout will have the date of the error and the message.
     * @param msg the message that will be printed out.
     */
    void showErrorMsg(String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append("**** NOTIFICATION CASHIER ****");
        builder.append(NEW_LINE);
        builder.append(getDateOfToday());
        builder.append(", ERROR: ");
        builder.append(msg);
        builder.append(NEW_LINE);
        builder.append("******************************");
        builder.append(NEW_LINE);
        System.out.println(builder.toString());
    }

    private String getDateOfToday(){
        LocalDateTime now = LocalDateTime.now();
        return now.toLocalDate().toString();
    }
}
