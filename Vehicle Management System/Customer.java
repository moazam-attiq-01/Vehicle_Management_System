public class Customer {
    // Attributes
    private String name;
    private String username;
    private String password;
    private String contactNo;
    Vehicle ownedVehicle;
    Customer next;
    
    // Default constructor
    public Customer() {
        this.name = "Unknown";
        this.username = null;
        this.password = null;
        this.contactNo = null;        
    }
    public Customer(String name) {
        this.name = name;
    }
    // Constructor with all attributes
    public Customer(String name, String username, String password, String contactNo) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.contactNo = contactNo;
    }
    
    // Getter and Setter for ownedVehicle
    public void setOwnedVehicle(Vehicle vehicle) {
        this.ownedVehicle = vehicle;
    }   

    public Vehicle getOwnedVehicle() {
        return this.ownedVehicle;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for contactNo
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString(){
        return "UserName: " + getUsername() + "\nContact No: " + getContactNo();
    }

    public void purchaseVehicle(Vehicle vehicle, double purchasePrice) {
        vehicle.setOwner(this);
        vehicle.purchasePrice = purchasePrice;
        ownedVehicle = vehicle;
    }

    // Method to sell a vehicle
    public void sellVehicle(Vehicle vehicle, double sellingPrice) {
        vehicle.sell(sellingPrice);
        vehicle.setOwner(null);
    }
}