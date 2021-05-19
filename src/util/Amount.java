package util;

import java.util.Objects;

/**
 * Represent the amount of something, like money or items.
 */
public class Amount {
    private final int amount;

    /**
     * Creates an instance, representing the specified amount.
     *
     * @param amount The amount represented by the newly created instance.
     */
    public Amount(int amount){
        this.amount = amount;
    }

    /**
     * Get the value of amount.
     *
     * @return The value of amount.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Makes the <code>Amount</code> into a <code>String</code> object.
     *
     * @return <code>Amount</code> as a <code>String</code>.
     */
    @Override
    public String toString() {
        return Integer.toString(amount);
    }

    /**
     * Checks if the specified amount is equal to this amount.
     *
     * @param obj The specified amount
     * @return <code>false</code> if it's not the same kind of object or class or
     * amount is not the same. <code>true</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Amount other = (Amount) obj;
        if (!Objects.equals(this.amount, other.amount)){
            return false;
        }
        return true;
    }

    /**
     * Will subtract with the specified <code>Amount</code>
     *
     * @param other The specified <code>Amount</code>
     * @return The difference of this <code>Amount</code>
     * with the other <code>Amount</code>
     */
    public Amount minus(Amount other){
        return new Amount(this.amount - other.amount);
    }

    /**
     * Will add with the specified <code>Amount</code>
     *
     * @param other The specified <code>Amount</code>
     * @return The sum of this <code>Amount</code> with the other <code>Amount</code>
     */
    public Amount plus(Amount other){
        return new Amount(this.amount + other.amount);
    }

    /**
     * Will multiply with the specified <code>Amount</code>
     *
     * @param other The specified <code>Amount</code>
     * @return The product of this <code>Amount</code> with the other <code>Amount</code>
     */
    public Amount multiply(Amount other){ return new Amount(this.amount * other.amount);}

}
