package view;

import model.PaymentObserver;
import model.Total;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This view will display the total revenue when a payment have been made.
 */
public class TotalRevenueView implements PaymentObserver{
    private Total totalRevenue;
    private PrintWriter printWriter;
    private final String FILE_NAME = "TotalRevenue.txt";


    /**
     * Creates an instance of <code>TotalRevenueView</code>
     */
    public TotalRevenueView(){
        totalRevenue = new Total();
        try {
            printWriter = new PrintWriter(new FileWriter(FILE_NAME), true);
        }catch (IOException exc){
            System.out.println("Could not create the FileRev");
            exc.printStackTrace();
        }

    }

    /**
     * Updates the total revenue.
     * @param total the total that will be added to this <code>totalRevenue</code>
     */
    @Override
    public void updateTotal(Total total) {
        totalRevenue.updateTotal(total);
        printCurrentRevenue();
    }

    private void printCurrentRevenue(){
        StringBuilder builder = new StringBuilder();
        builder.append("****** DISPLAY ******");
        builder.append("\n");
        builder.append("*** TOTAL REVENUE ***");
        builder.append("\n");
        builder.append(("   Amount: " + totalRevenue.getTotalWithTax().toString()));
        printWriter.println(builder.toString());
//        exc.printStackTrace(printWriter);
        printWriter.println("*********************");

        System.out.println("****** DISPLAY ******");
        System.out.println("*** TOTAL REVENUE ***");
        System.out.println("   Amount: " + totalRevenue.getTotalWithTax().toString());
        System.out.println("*********************\n");
    }

}
