package util;

import java.time.LocalDateTime;

/**
 * Takes care of all the exception that will be logged.
 */
public abstract class LogHandler {
    protected final String NEW_LINE = "\n";

    /**
     * Prints out a log, that shows the exception that has been thrown.
     * @param exc the exception will be printed out.
     */
    public abstract void showLogException(Exception exc);

    /**
     * Gets the date of today.
     * @return The date of today.
     */
    protected String getDateOfToday(){
        LocalDateTime now = LocalDateTime.now();
        return now.toLocalDate().toString();
    }
}
