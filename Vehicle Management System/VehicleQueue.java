import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Node {
  Vehicle vehicle;
  Customer customer;
  Node next;

  public Node(Vehicle vehicle) {
    this.vehicle = vehicle;
    this.next = null;
  }

  public Node(Customer customer) {
    this.customer = customer;
    this.next = null;
  }
}

class VehicleQueue {
  private Node head;
  private Node tail;

  public VehicleQueue() {
    head = null;
    tail = null;
  }

  public void enqueue(Vehicle vehicle) {
    Node newNode = new Node(vehicle);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  public Vehicle dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty!");
    }
    Vehicle removedVehicle = head.vehicle;
    if (head == tail) {
      head = tail = null;
    } else {
      head = head.next;
    }
    return removedVehicle;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void saveToFile(String fileName) {
      try (FileWriter writer = new FileWriter(fileName)) {
        Node tempNode = head;
        while (tempNode != null) {
          writer.write(tempNode.vehicle.make + "," + tempNode.vehicle.model + "," + tempNode.vehicle.year + "," + tempNode.vehicle.licensePlate + "," + tempNode.vehicle.owner.getName() + "\n");
          tempNode = tempNode.next;
        }
        //System.out.println("Vehicle data saved to file!");
        writer.close();
      } catch (IOException e) {
        System.out.println("Error saving data to file: " + e.getMessage());
      }
    } // Add closing curly brace here

    public Vehicle searchVehicle(String license){
      Node current = head;
      while (current != null) {
        if (current.vehicle.licensePlate.equals(license)) {
          return current.vehicle;
        }
        current = current.next;
      }
      System.out.println("No Such vehicle Found! License Plate Number : "+license);
      return null;
    }

    public void registerVehicle() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter vehicle make: ");
      String make = scanner.nextLine();
      System.out.print("Enter vehicle model: ");
      String model = scanner.nextLine();
      System.out.print("Enter vehicle year: ");
      int year = scanner.nextInt();
      scanner.nextLine(); // consume newline character
      System.out.print("Enter vehicle license plate: ");
      String licensePlate = scanner.nextLine();
      System.out.print("Enter vehicle type: ");
      String type = scanner.nextLine();


      Customer customer = getCustomerFromFile("Customer.txt");
      if (customer == null) {
          System.out.println("Error: Customer not found! Please register the customer first.");
          return;
      }

      Vehicle newVehicle = new Vehicle(make, model, year, licensePlate, type);
      customer.setOwnedVehicle(newVehicle);
      newVehicle.setOwner(customer);

      enqueue(newVehicle); // Use the queue methods

      System.out.println("Vehicle registered successfully!");
      saveToFile("Vehicles.txt");
    }

  private Customer getCustomerFromFile(String fileName) {
    ArrayList<Customer> customers = new ArrayList<>();
    try (Scanner reader = new Scanner(new File(fileName))) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] data = line.split(",");
            if (data.length == 4) {
                Customer newCustomer = new Customer(data[1]);
                customers.add(newCustomer);
            } else {
                System.out.println("Error: Invalid customer data format in file!");
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error: Customer file not found!");
        return null;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter customer name (from file): ");
    String enteredName = scanner.nextLine();
    for (Customer customer : customers) {
      if (customer.getName().equals(enteredName)) {
        return customer;
      }
    }

    System.out.println("Error: Customer not found in the loaded data!");
    return null;
  }
}
