import java.util.*;
public class InvoiceManager implements Invoice {
    private int invoiceID;
    private double totalCost;
    private List<Services> items; // List of items/services included in the invoice
    private static int numberOfInvoices = 0;

    public InvoiceManager() {
        ++numberOfInvoices;
        this.invoiceID = numberOfInvoices;
        this.totalCost = 0.0;
        this.items = new ArrayList<>();
    }

    @Override
    public int getInvoiceID() {
        return invoiceID;
    }

    @Override
    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    @Override
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public void calculateTotal() {
        double addedTotal = 0;
        for (Services item : items) {
            addedTotal += item.getServiceCost();
        }
        totalCost += addedTotal;
    }

    @Override
    public void printInvoice() {
        // Print invoice details, including invoice ID, total cost, and list of items/services
        System.out.println("Invoice ID: " + invoiceID);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Items/Services:");
        if (items.size() == 0) {
            System.out.println("No Items/Services were used!");
        } else {
            for (Services item : items) {
                System.out.println("- " + item);
            }
        }
    }

    @Override
    public void recordPayment() {
        PaymentRecord paymentRecord = new PaymentRecord(invoiceID, totalCost);
        paymentRecord.writeToFile();
    }

}
