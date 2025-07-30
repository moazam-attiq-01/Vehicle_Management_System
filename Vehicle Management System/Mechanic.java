import java.util.*;
public class Mechanic {
    private final double salaryPerHour = 15;
    private String username;
    private String password;
    private String name;
    private int hoursWorked;
    private List<ServiceRequest> assignedRequests;

    // Default constructor
    public Mechanic() {
        this.password = null;
        this.username = null;
        this.name = null;
        this.hoursWorked = 0;
        this.assignedRequests = new ArrayList<>();
    }

    // Constructor with all attributes
    public Mechanic(String name, String username, String password) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.hoursWorked = 0;
        this.assignedRequests = new ArrayList<>();
    }

    // Getter and Setter for username
    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ServiceRequest> getAssignedRequests(){
        return this.assignedRequests;
    }

    public void assignRequest(ServiceRequest request) {
        assignedRequests.add(request);
    }

    public double calculateSalary() {
        for (int i = 0; i < assignedRequests.size(); ++i) {
            this.hoursWorked += assignedRequests.get(i).services.getCompletionTime();
        }
        return (this.hoursWorked * this.salaryPerHour);
    }
}
