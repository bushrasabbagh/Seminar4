package util;

/**
 * Represents an discount with certain rules.
 */
public class DiscountRule {
    private double discountRate;
    private final double NO_DISCOUNT_RATE = 1.0;

    /**
     * Creates a new instance, representing a discount rule.
     *
     * @param discountRate The discount rate represented by the newly created instance.
     */
    public DiscountRule(double discountRate){
        this.discountRate = discountRate;
    }

    /**
     *  Creates a new instance, representing the discount rate 1.0.
     */
    public DiscountRule(){
        this.discountRate = NO_DISCOUNT_RATE;
    }

    /**
     * Get the value of discountRate.
     *
     * @return The value of discountRate.
     */
    public double getDiscountRate() {
        return discountRate;
    }

}
