import java.io.*;
public class InventoryManager {
    private InventoryTreeNode root;

    public InventoryManager() {
        root = null;
        readDataFromFile("Inventory.txt");
    }

    public void readDataFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Vehicle vehicle = new Vehicle(parts[0]);
                    int quantity = Integer.parseInt(parts[1]);
                    addVehicleToInventory(vehicle, quantity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Inventory.txt"))) {
            saveDataToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDataToFile(InventoryTreeNode node, PrintWriter writer) {
        if (node == null) {
            return;
        }

        saveDataToFile(node.getLeft(), writer);
        writer.println(node.getVehicle().model + "," + node.getQuantity());
        saveDataToFile(node.getRight(), writer);
    }
    public void addVehicleToInventory(Vehicle vehicle, int quantity) {
        if (root == null) {
            root = new InventoryTreeNode(vehicle, quantity);
        } else {
            addVehicleToTree(root, vehicle, quantity);
        }
        saveDataToFile();
    }

    private void addVehicleToTree(InventoryTreeNode node, Vehicle vehicle, int quantity) {
        if (node.getVehicle().equals(vehicle)) {
            node.setQuantity(node.getQuantity() + quantity);
            return;
        }
    
        InventoryTreeNode child = node.getLeft();
        if (child != null) {
            addVehicleToTree(child, vehicle, quantity);
        }
    
        child = node.getRight();
        if (child != null) {
            addVehicleToTree(child, vehicle, quantity);
        }
    
        // If the vehicle is not found in the tree, add a new node as a child
        if (child == null) {
            InventoryTreeNode newNode = new InventoryTreeNode(vehicle, quantity);
            if (node.getVehicle().compareTo(vehicle) >= 0) {
                node.setRight(newNode);
            } else {
                node.setLeft(newNode);
            }
        }
    }
    public void printModels() {
        printModels(root);
    }

    private void printModels(InventoryTreeNode node) {
        if (node == null) {
            return;
        }

        printModels(node.getLeft());
        System.out.println(node.getVehicle().model + " ");
        printModels(node.getRight());
    }
}