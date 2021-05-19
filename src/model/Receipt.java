package model;

import java.time.LocalDateTime;

/**
 *  Represents a receipt.
 */
public class Receipt {
    private Sale sale;

    /**
     * Creates a new instance, representing a receipt.
     *
     * @param sale The information that will be on the receipt.
     */
    public Receipt(Sale sale){
        this.sale = sale;
    }

    /**
     * Makes the instance into a <code>String</code>
     *
     * @return Tbe instance as a <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        addNewLine(builder);
        appendLine(builder, "----------RECEIPT----------");
        addLocalDate(builder);
        appendLine(builder, "Items: ");
        appendLine(builder, sale.toString());
        appendLine(builder, "------------END------------");
        return builder.toString();
    }

    private void addNewLine(StringBuilder builder){
        builder.append("\n");
    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        addNewLine(builder);
    }

    private void addLocalDate(StringBuilder builder){
        LocalDateTime saleTime = LocalDateTime.now();
        appendLine(builder, "Sale time: " + saleTime.toLocalDate().toString());
    }

}
