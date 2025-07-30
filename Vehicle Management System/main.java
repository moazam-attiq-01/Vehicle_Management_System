import java.io.*;
import java.util.*;

class main {
	static Scanner sc = new Scanner(System.in);
	static UserManagement uManage = new UserManagement();
	static VehicleQueue v = new VehicleQueue();
	static ServiceRequestManager srm = new ServiceRequestManager();
	static InventoryManager iManager = new InventoryManager();
	static String mechanicName = null;
	static InvoiceManager inManager = new InvoiceManager();
    public static void main(String[] args) throws FileNotFoundException {

		Scanner fReader = new Scanner(System.in);
		boolean outerFlag = true;

		while(outerFlag){
			System.out.println("\n-------------------------------");
			System.out.println("  Vehicle Management System");
			System.out.println("-------------------------------");
 
			System.out.println("1. Customer Login");
			System.out.println("2. Customer Register");
			System.out.println("3. Employee Login");
			System.out.println("4. Admin Login");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
				case 1:
				boolean innerFlag = true;
				
				if (login(fReader)) {
					customerMenu();
				}
					break;
				case 2:
					register(sc);
					break;
				case 3:
				if(employeeLogin(fReader)) {
					mechanicMenu();
				}
				break;
				case 4:
					adminLogin();
					break;
				case 5:
					outerFlag = false;
					System.out.println("\nThank you for choosing our services.\n");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}

		}
    }
	public static void adminMenu() {
		boolean innerFlag = true;

		while (innerFlag) {
			System.out.println("\n-------------------");
			System.out.println("W  E  L  C  O  M  E");
			System.out.println("-------------------");
			System.out.println("1. Remove Mechanic:");
			System.out.println("2. Remove Customer:");
			System.out.println("3. Add new Stock:");
			System.out.println("4. Payment Record:");
			System.out.println("5. Logout:");
			System.out.print("Enter your choice: ");

			int c_choice = sc.nextInt();

			switch (c_choice) {
				case 1:
					System.out.println("Enter Mechanic's username: ");
					String username = sc.next();
					sc.nextLine();
					uManage.removeMechanic(username);
					break;
				case 2:
					System.out.println("Enter Customer's username: ");
					String username1 = sc.next();
					sc.nextLine();
					uManage.removeCustomer(username1);
				break;
				case 3:
					System.out.println("Enter Model: ");
					String model = sc.next();
					sc.nextLine();
					System.out.println("Enter Quantity: ");
					int quantity = sc.nextInt();
					sc.nextLine();
					Vehicle vehicle = new Vehicle(model);
					iManager.addVehicleToInventory(vehicle, quantity);
					break;
				case 4:
					inManager.recordPayment();
				break;
				case 5:
					innerFlag = false;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		}
	}
	public static void mechanicMenu() {
		boolean innerFlag = true;

        while (innerFlag) {
            System.out.println("\n-------------------");
            System.out.println("W  E  L  C  O  M  E");
            System.out.println("-------------------");
			System.out.println("1. Check Hours Worked:");
            System.out.println("2. Check Salary:");            
			System.out.println("3. Logout:");
			System.out.print("Enter your choice: ");

			int c_choice = sc.nextInt();

			switch (c_choice) {
				case 1:
					Mechanic mec2 = uManage.findUserByUsernameMechanic(mechanicName);
					srm.assignRequestToMechanic(mec2);
				case 2:
					Mechanic mec = uManage.findUserByUsernameMechanic(mechanicName);
					System.out.println("Salary: " + mec.calculateSalary());
					break;	
				case 3:
					innerFlag = false;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		}
	}
	public static void customerMenu() {
        boolean innerFlag = true;

        while (innerFlag) {
            System.out.println("\n-------------------");
            System.out.println("W  E  L  C  O  M  E");
            System.out.println("-------------------");
            System.out.println("1. Register a new car");
            System.out.println("2. Service Offered");
            System.out.println("3. Purchase/Sell Vehicle");
			System.out.println("4. Generate Invoice");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int c_choice = sc.nextInt();

            switch (c_choice) {
                case 1:
				v.registerVehicle();
				break;
                case 2:
					offeredServices();
                    break;
				case 3:
					exchangeOfVehicle();
					break;
                case 4:
				dueClearance();
                    break;
                case 5:
                    innerFlag = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

	private static void dueClearance(){
		inManager.printInvoice();
	}
	private static void exchangeOfVehicle(){
		boolean flag = true;
		while (flag) {
			System.out.println("\n1. Purchase Vehicle");
			System.out.println("2. Sell Vehicle");
			System.out.print("Enter Choice: ");
			int choice=sc.nextInt();
			switch (choice) {
				case 1:
					iManager.printModels();
					System.out.println("Select Car: ");
					int c_choice = sc.nextInt();
					switch (c_choice) {
						case 1:
						System.out.print("Enter your username: ");
						String username = sc.next();
						sc.nextLine();
						Customer c = uManage.findUserByUsernameCustomer(username);
						c.purchaseVehicle(new Vehicle("Corolla"), 10_000_000);
						System.out.println("Vehicle Booked!");
						break;
						case 2:
						System.out.print("Enter your username: ");
						String username2 = sc.next();
						sc.nextLine();
						Customer c2 = uManage.findUserByUsernameCustomer(username2);
						c2.purchaseVehicle(new Vehicle("Alto"), 1_000_000);
						System.out.println("Vehicle Booked!");
						break;
						case 3:
						System.out.print("Enter your username: ");
						String username3 = sc.next();
						sc.nextLine();
						Customer c3 = uManage.findUserByUsernameCustomer(username3);
						c3.purchaseVehicle(new Vehicle("Corolla"), 10_000_000);
						System.out.println("Vehicle Booked!");
						break;
						case 4:
						System.out.print("Enter your username: ");
						String username4 = sc.next();
						sc.nextLine();
						Customer c4 = uManage.findUserByUsernameCustomer(username4);
						c4.purchaseVehicle(new Vehicle("Sportage"), 10_000_000);
						System.out.println("Vehicle Booked!");
						break;
						case 5:
						System.out.print("Enter your username: ");
						String username5 = sc.next();
						sc.nextLine();
						Customer c5 = uManage.findUserByUsernameCustomer(username5);
						c5.purchaseVehicle(new Vehicle("Vitz"), 10_000_000);
						System.out.println("Vehicle Booked!");
						break;
						case 6:
						System.out.print("Enter your username: ");
						String username6 = sc.next();
						sc.nextLine();
						Customer c6 = uManage.findUserByUsernameCustomer(username6);
						c6.purchaseVehicle(new Vehicle("Swift"), 10_000_000);
						System.out.println("Vehicle Booked!");
						break;
						case 7:
						System.out.print("Enter your username: ");
						String username7 = sc.next();
						sc.nextLine();
						Customer c7 = uManage.findUserByUsernameCustomer(username7);
						c7.purchaseVehicle(new Vehicle("City"), 10_000_000);
						System.out.println("Vehicle Booked!");
						break;
						case 8:
						System.out.print("Enter your username: ");
						String username8 = sc.next();
						sc.nextLine();
						Customer c8 = uManage.findUserByUsernameCustomer(username8);
						c8.purchaseVehicle(new Vehicle("Civic"), 10_000_000);
						System.out.println("Vehicle Booked!");
						break;					
						default:
						System.out.println("Invalid choice. Please try again.");
							break;
					}
					break;
				case 2:
					System.out.println("Enter Model: ");
					String model = sc.next();
					sc.nextLine();
					System.out.print("Enter your username: ");
					String username = sc.next();
					sc.nextLine();
					Customer c = uManage.findUserByUsernameCustomer(username);
					c.sellVehicle(new Vehicle(model), 3_000_000);
					System.out.println("Car bought for 3 Millions");
				break;
				default:
				System.out.println("Invalid choice. Please try again.");
					break;
			}
		}
	}

	private static void offeredServices(){
		Services s1 = new Services("Brakes Service", 2000, 3);
		Services s2 = new Services("Oil Change", 2000, 1);
		Services s3 = new Services("Suspension Work", 10_000, 5);
		Services s4 = new Services("Engine Tune Up", 10_000, 10);
		ArrayList<Services> serviceList = new ArrayList<>();
		serviceList.add(s1);
		serviceList.add(s2);
		serviceList.add(s3);
		serviceList.add(s4);

		serviceSelection(serviceList);
	}

	private static void serviceSelection(ArrayList<Services> serviceList){
		boolean flag = true;
		while (flag) {
			System.out.println("\n1. Brakes Service");
            System.out.println("2. Oil Change");
            System.out.println("3. Suspension Work");
            System.out.println("4. Engine Tune Up");
            System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			System.out.print("Enter Vehicle License Plate: ");
			String licensePlate = sc.next();
			sc.nextLine();
			Vehicle car = v.searchVehicle(licensePlate);
			if (car != null) {
			switch (choice) {
				case 1:
					ServiceRequest sRequest1 = new ServiceRequest(licensePlate, serviceList.get(choice));
					srm.addRequest(sRequest1);
					break;
				case 2:
				ServiceRequest sRequest2 = new ServiceRequest(licensePlate, serviceList.get(choice));
				srm.addRequest(sRequest2);
					break;
				case 3:
				ServiceRequest sRequest3 = new ServiceRequest(licensePlate, serviceList.get(choice));
				srm.addRequest(sRequest3);
					break;
				case 4:
				ServiceRequest sRequest4 = new ServiceRequest(licensePlate, serviceList.get(choice));
				srm.addRequest(sRequest4);
					break;	
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
			System.out.println("Request Forwaded. \nVehicle in Queue for work.");
			flag = false;
		} else {
			flag = false;
		}
		}
	}

	private static void adminLogin(){
		System.out.println("Enter username : ");
        String username = sc.next();
		sc.nextLine();
        System.out.println("Enter password : ");
        String password = sc.nextLine();
		boolean validLogin = false;

		if (username.equals("admin") && password.equals("admin123")) {
			validLogin = true;
		}

		if (validLogin) {
            System.out.println("Login successful.");
			adminMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
	}

	private static boolean employeeLogin(Scanner fReader) throws FileNotFoundException {
        System.out.println("Enter username : ");
        String username = fReader.nextLine();
        System.out.println("Enter password : ");
        String password = fReader.nextLine();

		mechanicName = username;

        File loginInfo = new File("Mechanic.txt");
        Scanner fileScanner = new Scanner(loginInfo);

        boolean isUserValid = false;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] details = line.split(",");

            if (username.equals(details[1]) && password.equals(details[2])) {
                isUserValid = true;
                break;
            }
        }

        fileScanner.close();

        if (isUserValid) {
            System.out.println("Login successful.");
			return true;
        } else {
            System.out.println("Invalid username or password.");
			return false;
        }
    }

    private static boolean login(Scanner fReader) throws FileNotFoundException {
        System.out.println("Enter username : ");
        String username = fReader.nextLine();
        System.out.println("Enter password : ");
        String password = fReader.nextLine();

        File loginInfo = new File("Customer.txt");
        Scanner fileScanner = new Scanner(loginInfo);

        boolean isUserValid = false;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] details = line.split(",");

            if (username.equals(details[1]) && password.equals(details[2])) {
                isUserValid = true;
                break;
            }
        }

        fileScanner.close();

        if (isUserValid) {
            System.out.println("Login successful.");
			return true;
        } else {
            System.out.println("Invalid username or password.");
			return false;
        }
		
    }

    private static void register(Scanner fReader)  {
		System.out.println("Enter name : ");
		String name = sc.next();
		sc.nextLine();
		System.out.println("Enter username : ");
		String username = sc.next();
		sc.nextLine();
		System.out.println("Enter password : ");
		String password = sc.next();
		sc.nextLine();
		System.out.println("Enter contact no : ");
		String contactNo = sc.nextLine();
	
		try {
			FileWriter fw = new FileWriter("Customer.txt", true);
			fw.write(name + "," + username + "," + password + "," + contactNo + "\n");
			fw.close();
		//	customerList.add(new Customer(name, username, password, contactNo));
		} catch (IOException e) {
			System.out.println("Error occurred while registering the user.");
			e.printStackTrace();
		}
	
		System.out.println("Registration successful.");
	}

	// private static Customer searchCustomer(String username){
	// 	boolean isFound = false;
	// 	for(int i=0 ; i < customerList.size() ; ++i){
	// 		if (customerList.get(i).getUsername().equals(username)) {
	// 			isFound = true;
	// 			return customerList.get(i);
	// 		}
	// 	}
	// 	if (!isFound) {
	// 		System.out.println("No such customer exists.");
	// 	}
	// 	return null;
	// }


    private static void registerCar(Scanner sc) {
        System.out.print("Enter Type: ");
        String type = sc.next();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Make: ");
        String make = sc.nextLine();
        System.out.print("Enter Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Year registered: ");
        int year = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter License Plate: ");
        String l_plate = sc.nextLine();
       // carList.add(new Vehicle(make, model, year, l_plate, type));

    }
}