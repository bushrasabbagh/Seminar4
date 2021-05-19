package model;

import util.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 *  Represents a payment of a specific sale.
 */
public class Payment {
    private List<PaymentObserver> paymentObservers = new ArrayList();
    private Amount paidAmount;
    private Total total;

    /**
     * Creates a new instance, represented as a payment.
     *
     * @param paidAmount The amount money the customer have given.
     * @param total The total that will that will be payed for by the customer.
     */
    public Payment(Amount paidAmount, Total total){
        this.paidAmount = paidAmount;
        this.total = total;

    }

    private void notifyObservers(){
        for (PaymentObserver obs : paymentObservers) {
            obs.updateTotal(total);
        }
    }

    /**
     * The specified observers will be notified when a payment is made.
     * @param observers The observers to notify.
     */
    public void addPaymentObservers(List<PaymentObserver> observers) {
        paymentObservers.addAll(observers);
    }

    /**
     * Get the total cost of the payment.
     *
     * @return The total cost.
     */
    Total getTotal() {
        return total;
    }

    /**
     *  Calculates the amount of change and returns it as an {@link Amount}
     *
     * @return The total change as {@link Amount}
     */
    public Amount getChange(){
        notifyObservers();
        return paidAmount.minus(total.getTotalWithTax());
    }




}
