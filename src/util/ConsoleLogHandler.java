package util;

/**
 * Takes care of all the exceptions that will be logged and printed out to the console.
 */
public class ConsoleLogHandler extends LogHandler {
    private static final ConsoleLogHandler CONSOLE_LOG_HANDLER = new ConsoleLogHandler();

    private ConsoleLogHandler(){ }

    /**
     * Gets the singleton instance of <code>ConsoleLogHandler</code>
     * @return The <code>ConsoleLogHandler</code>
     */
    public static ConsoleLogHandler getLogHandler() {
        return CONSOLE_LOG_HANDLER;
    }

    /**
     * Prints the exception to the console, it will print the message, date and the exceptions.
     * @param exc the exception will be printed out.
     */
    @Override
    public void showLogException(Exception exc) {
        StringBuilder builder = new StringBuilder();
        builder.append("************ LOG *************");
        builder.append(NEW_LINE);
        builder.append(getDateOfToday());
        builder.append(", Exception was thrown: ");
        builder.append(exc.getMessage());
        builder.append(NEW_LINE);
        System.out.println(builder.toString());
        exc.printStackTrace(System.out);
        System.out.println("******************************");
    }
}
