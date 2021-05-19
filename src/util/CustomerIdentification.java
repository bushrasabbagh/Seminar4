package util;

import java.util.Objects;

/**
 * Represents an identification of a customer.
 */
public class CustomerIdentification {
    private String customerIdentificationNumber;

    /**
     * Creates an new instance, representing the specified customer identification.
     *
     * @param customerIdentificationNumber The identification number represented by the newly created instance.
     */
    public CustomerIdentification(String customerIdentificationNumber){
        this.customerIdentificationNumber = customerIdentificationNumber;
    }

    /**
     * Get the value of customerIdentificationNumber.
     *
     * @return The value of costumerIdentificationNumber.
     */
    public String getCustomerIdentificationNumber() {
        return customerIdentificationNumber;
    }

    /**
     * Checks if this instance is equal to another instance.
     * @param obj The other instance.
     * @return <code>true</code> if all attributes are the same, the same class and if it is not null. <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final CustomerIdentification other = (CustomerIdentification) obj;
        if (!Objects.equals(this.customerIdentificationNumber, other.customerIdentificationNumber)) {
            return false;
        }
        return true;
    }
}
