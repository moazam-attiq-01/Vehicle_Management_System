import java.io.FileWriter;
import java.io.IOException;

public class PaymentRecord {
    private int invoiceID;
    private double paymentAmount;

    public PaymentRecord(int invoiceID, double paymentAmount) {
        this.invoiceID = invoiceID;
        this.paymentAmount = paymentAmount;
    }

    // Getter methods
    public int getInvoiceID() {
        return invoiceID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }


    // Method to write payment record to a file
    public void writeToFile() {
        try (FileWriter writer = new FileWriter("PaymentRecord.txt", true)) {
            writer.write(invoiceID + "," + paymentAmount + "\n");
        } catch (IOException e) {
            System.out.println("Error writing payment record to file: " + e.getMessage());
        }
    }
}
