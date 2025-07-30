class Vehicle implements Comparable<Vehicle>{
    String make, model, licensePlate, type;
    int year;
    Customer owner;
    double purchasePrice;
    double sellingPrice;

    public Vehicle(String make, String model, int year, String licensePlate, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.licensePlate = licensePlate;
    }

    public Vehicle(String model){
        this.make = null;
        this.model = model;
        this.year = 1990;
        this.type = null;
        this.licensePlate = null;
    }

    public Vehicle(Vehicle v){
        this.make = v.make;
        this.model = v.model;
        this.year = v.year;
        this.type = v.type;
        this.licensePlate = v.licensePlate;
    }

    @Override
    public int compareTo(Vehicle other) {
        return new SortByYear().compare(this, other);
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void sell(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return owner.getName();
    }
}

class VehicleNode {
    Vehicle vehicle;
    VehicleNode next;

    public VehicleNode(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.next = null;
    }
}