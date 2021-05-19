package view;

import model.PaymentObserver;
import model.Total;

/**
 * This view will display the total revenue when a payment have been made.
 */
public class TotalRevenueView implements PaymentObserver{
    private Total totalRevenue;

    /**
     * Creates an instance of <code>TotalRevenueView</code>
     */
    public TotalRevenueView(){
        totalRevenue = new Total();
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
        System.out.println("****** DISPLAY ******");
        System.out.println("*** TOTAL REVENUE ***");
        System.out.println("   Amount: " + totalRevenue.getTotalWithTax().toString());
        System.out.println("*********************\n");
    }

}
