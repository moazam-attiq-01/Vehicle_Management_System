public class Services {
    private String serviceName;
    private double serviceCost;
    private int completionTime;

    // Default constructor
    public Services() {
        this.serviceName = null;
        this.serviceCost = 0.0;
        this.completionTime = 0;
    }

    // Constructor with all attributes
    public Services(String serviceName, double serviceCost, int compTime) {
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
        this.completionTime = compTime;
    }

    // Getter and Setter for serviceName
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    // Getter and Setter for serviceCost
    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public void setCompletionTime(int compTime){
        this.completionTime = compTime;
    }

    public int getCompletionTime(){
        return this.completionTime;
    }

    @Override
    public String toString() {
        return ("Service Name: " + getServiceName() + "\nService Cost: " + getServiceCost() + "\n\n");
    }
}
