import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class UserManagement {
    private ArrayList<Customer> customers;
    private ArrayList<Mechanic> mechanics;    
    private final String fileCustomer = "Customer.txt";
    private final String fileMechanic = "Mechanic.txt";

    public UserManagement() {
        this.customers = new ArrayList<>(); // Initially no Customer
        this.mechanics = new ArrayList<>(); // Initially no Mechanics
        loadCustomerFromFile(); // Load existing users if file exists
        loadMechanicFromFile(); // Load existing users if file exists
    }

    // Create a new customer
    public void createCustomer(String name, String username, String password, String contactNo) {
        // Check for existing user
        if (findCustomerByUsername(username)) {
            System.out.println("Customer already exists!");
            return;
        }

        // Create user object
        Customer newCustomer = new Customer(name, username, password, contactNo);
        customers.add(newCustomer); // Add to list of users
        System.out.println("Customer created successfully!");
        // Save user data to file
        saveCustomerToFile();
    }

    // Create a new Mechanic
    public void createMechanic(String name, String username, String password) {
        // Check for existing user
        if (findUserByUsernameMechanic(username) != null) {
            System.out.println("Mechanic already exists!");
            return;
        }

        // Create user object
        Mechanic newMechanic = new Mechanic(name, username, password);
        mechanics.add(newMechanic); // Add to list of users
        System.out.println("Mechanic created successfully!");
        // Save user data to file
        saveMechanicToFile();
    }
    boolean findCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    // Find a customer by username
    Customer findUserByUsernameCustomer(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    // Find a Mechanic by username
    Mechanic findUserByUsernameMechanic(String username) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getUsername().equals(username)) {
                return mechanic;
            }
        }
        return null;
    }

    private void loadCustomerFromFile() {
        try (Scanner scanner = new Scanner(new File(fileCustomer))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",", 4); // Limit to 4 elements for Customer
                if (data.length == 4) { // Ensure full data for Customer
                    createCustomer(data[0], data[1], data[2], data[3]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading Customer from file: " + e.getMessage());
        }
    }
    

    private void loadMechanicFromFile() {
        try (Scanner scanner = new Scanner(new File(fileMechanic))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] data = line.split(",", 3); // Limit to 3 elements for Mechanic
                if (data.length == 3) { // Ensure full data for Mechanic
                    createMechanic(data[0], data[1], data[2]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading Mechanic from file: " + e.getMessage());
        }
    }

    // Remove a customer
    public void removeCustomer(String username) {
        // Find the customer
        Customer customerToRemove = findUserByUsernameCustomer(username);

        if (customerToRemove != null) {
            // Remove the customer from the list
            customers.remove(customerToRemove);
            System.out.println("Customer removed successfully!");

            // Save customer data to file
            saveCustomerToFile();
        } else {
            System.out.println("Customer not found!");
        }
    }

    // Remove a mechanic
    public void removeMechanic(String username) {
    // Find the mechanic
        Mechanic mechanicToRemove = findUserByUsernameMechanic(username);

        if (mechanicToRemove != null) {
            // Remove the mechanic from the list
            mechanics.remove(mechanicToRemove);
            System.out.println("Mechanic removed successfully!");

            // Save mechanic data to file   
            saveMechanicToFile();
        } else {
            System.out.println("Mechanic not found!");
        }
    }
    
    private void saveCustomerToFile() {
            try (FileWriter writer = new FileWriter(fileCustomer)) {
                for (Customer customer : customers) {
                    writer.write(customer.getName() + "," + customer.getUsername() + "," + customer.getPassword() + ","+customer.getContactNo() + "\n"); // Modify if data format changes
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error saving users to file: " + e.getMessage());
            }
        } 

        private void saveMechanicToFile() {
        try (FileWriter writer = new FileWriter(fileMechanic)) {
            for (Mechanic mechanic : mechanics) {
                writer.write(mechanic.getName() + "," + mechanic.getUsername() + "," + mechanic.getPassword() + "\n"); // Modify if data format changes
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }

    }

}
