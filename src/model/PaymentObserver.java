package model;

/**
 * A listener interface for receiving the total when a payment have been made.
 * For classes that are interested in getting such notifications implements this interface.
 * In order to register the class it's needed to all {@link controller.Controller#addPaymentObserver(PaymentObserver)}
 * A payment is made, that object's {@link #updateTotal(Total)} method is invoked.
 */
public interface PaymentObserver {

    /**
     * Invoked when a payment is made.
     * @param total the total of the made payment.
     */
    void updateTotal(Total total);
}
