public interface Invoice {
    // Getter method for invoiceID
    int getInvoiceID();

    // Setter method for invoiceID
    void setInvoiceID(int invoiceID);

    // Setter method for totalCost
    void setTotalCost(double totalCost);

    // Method to calculate the total cost
    void calculateTotal();

    // Method to print the invoice
    void printInvoice();

    // Method to record a payment
    void recordPayment();

}
