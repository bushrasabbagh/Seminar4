package view;

import model.PaymentObserver;
import model.Total;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Class will writes the total revenue when a payment have been made to a file.
 */
public class TotalRevenueFileOutput implements PaymentObserver{
    private Total totalRevenue;
    private PrintWriter printWriter;
    private final String FILE_NAME = "TotalRevenue.txt";


    /**
     * Creates an instance of <code>TotalRevenueFileOutput</code>
     */
    public TotalRevenueFileOutput(){
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
        outCurrentRevenueToFile();
    }

    private void outCurrentRevenueToFile(){
        StringBuilder builder = new StringBuilder();
        builder.append("*** TOTAL REVENUE ***");
        builder.append("\n");
        builder.append(("   Amount: " + totalRevenue.getTotalWithTax().toString()));
        printWriter.println(builder.toString());
        printWriter.println("*********************");

    }

}
