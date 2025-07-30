class ServiceRequest {
    private String vehicleLicensePlate;
    public Services services;

    public ServiceRequest(String vehicleLicensePlate, Services services) {
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.services = services;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate){
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    public String getVehicleLicensePlate(){
        return this.vehicleLicensePlate;
    }

    public String toString(){
        return ("Service Name: " + services.getServiceName() + ", Service Completion Time: " + services.getCompletionTime());
    }
}