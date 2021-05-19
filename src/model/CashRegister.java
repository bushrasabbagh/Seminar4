package model;

import util.Amount;

/**
 * Represents a dummy cash register.
 */
public class CashRegister {
    private Amount balance;

    /**
     * Creates a new instance of a cash register with a balance of zero.
     */
    public CashRegister(){
        this.balance = new Amount(0);
    }

    /**
     * Gets the value of balance.
     *
     * @return The value of balance.
     */
    public Amount getBalance() {
        return balance;
    }

    /**
     * Updates the balance wth the specified payment.
     *
     * @param payment The amount of money that will be added to the balance of the cash register.
     */
    public void addPayment(Payment payment){
        balance = balance.plus(payment.getTotal().getTotalWithTax());
    }
}
