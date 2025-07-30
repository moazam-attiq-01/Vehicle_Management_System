import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ServiceRequestManager {
    private LinkedList<ServiceRequest> pendingRequests;
    private LinkedList<Mechanic> mechanics;

    public ServiceRequestManager() {
        this.pendingRequests = new LinkedList<>();
        this.mechanics = loadMechanicsFromFile("Mechanic.txt");
    }

    private LinkedList<Mechanic> loadMechanicsFromFile(String fileName) {
        LinkedList<Mechanic> loadedMechanics = new LinkedList<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    loadedMechanics.add(new Mechanic(data[0], data[1], data[2]));
                } else {
                    System.out.println("Invalid mechanic data format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Mechanic file not found: " + e.getMessage());
        }
        return loadedMechanics;
    }

    public void addRequest(ServiceRequest request) {
        pendingRequests.add(request);
    }

    public void assignRequestToMechanic(Mechanic mechanic) {
        if (mechanics.contains(mechanic)) {
            mechanic.assignRequest(pendingRequests.get(1));
            pendingRequests.remove(0);            
        } else {
            System.out.println("No such mechanic is available!");
        }
    }
}
