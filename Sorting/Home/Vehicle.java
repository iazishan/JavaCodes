import java.util.Scanner;

class Vehicle {
    int id;
    String model;
    boolean available;
    double rent;

    public Vehicle(int id, String model, boolean available, double rent) {
        this.id = id;
        this.model = model;
        this.available = available;
        this.rent = rent;
    }

}

class VehicleNode {
    Vehicle vehicle;
    VehicleNode left, right;

    public VehicleNode(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

class VehicleBST {
    private VehicleNode root;

    public void listAvailableVehicles() {
        listAvailableVehicles(root);
    }

    private void listAvailableVehicles(VehicleNode node) {
        if (node == null)
            return;
        listAvailableVehicles(node.left);
        if (node.vehicle.available)
            System.out.println(node.vehicle);
        listAvailableVehicles(node.right);
    }

    public void displayVehiclesWithMinRent() {
        double minRent = findMinRent(root, Double.MAX_VALUE);
        displayVehiclesWithMinRent(root, minRent);
    }

    private double findMinRent(VehicleNode node, double min) {
        if (node == null)
            return min;
        min = Math.min(min, node.vehicle.rent);
        min = findMinRent(node.left, min);
        min = findMinRent(node.right, min);
        return min;
    }

    private void displayVehiclesWithMinRent(VehicleNode node, double minRent) {
        if (node == null)
            return;
        displayVehiclesWithMinRent(node.left, minRent);
        if (node.vehicle.rent == minRent)
            System.out.println(node.vehicle);
        displayVehiclesWithMinRent(node.right, minRent);
    }

    public int countTotalVehicles() {
        return countNodes(root);
    }

    private int countNodes(VehicleNode node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VehicleBST vehicleBST = new VehicleBST();
        vehicleBST.root = new VehicleNode(new Vehicle(1, "Car A", true, 100.0));
        vehicleBST.root.left = new VehicleNode(new Vehicle(2, "Car B", true, 150.0));
        vehicleBST.root.right = new VehicleNode(new Vehicle(3, "Car C", true, 80.0));
        vehicleBST.root.left.left = new VehicleNode(new Vehicle(4, "Car D", true, 120.0));
        vehicleBST.root.left.right = new VehicleNode(new Vehicle(5, "Car E", true, 200.0));

        while (true) {

            System.out.println("1. Show Available Vehicles");
            System.out.println("2. Show Vehicles with Minimum Rent");
            System.out.println("3. Count Total Vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Availble Cars: ");
                    vehicleBST.listAvailableVehicles();
                    break;
                case 2:
                    System.out.println("Vehicles with Minimum Rent: ");
                    vehicleBST.displayVehiclesWithMinRent();
                    break;

                case 3:
                    System.out.println("Total Vehicles Count: ");
                    int i = vehicleBST.countTotalVehicles();
                    System.out.println(i);

                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    break;
                default:
                    System.out.println("Multiple vehicles available.");
                    break;
            }

        }

    }
}