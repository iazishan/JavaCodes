
import java.util.Scanner;

class Patient {
    String name;
    int medicalNumber;
    String condition;
    boolean operation;

    public Patient(String name, int medicalNumber, String condition, boolean operation) {
        this.name = name;
        this.medicalNumber = medicalNumber;
        this.condition = condition;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Medical Number: " + medicalNumber +
                ", Condition: " + condition +
                ", Operation: " + (operation ? "Yes" : "No");
    }
}

class BSTNode {
    Patient patient;
    BSTNode left, right;

    public BSTNode(Patient patient) {
        this.patient = patient;
        left = right = null;
    }
}

class PatientBST {
    private BSTNode root;

    public void addPatient(Patient patient) {
        root = insert(root, patient);
    }

    private BSTNode insert(BSTNode node, Patient patient) {
        if (node == null) {
            return new BSTNode(patient);
        }

        if (patient.medicalNumber < node.patient.medicalNumber) {
            node.left = insert(node.left, patient);
        } else if (patient.medicalNumber > node.patient.medicalNumber) {
            node.right = insert(node.right, patient);
        } else {
            System.out.println("Duplicate medical number. Patient not added.");
        }
        return node;
    }

    public void listPatients() {
        inOrder(root);
    }

    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.patient);
            inOrder(node.right);
        }
    }

    public Patient searchByMedicalNumber(int medicalNumber) {
        return searchMedical(root, medicalNumber);
    }

    private Patient searchMedical(BSTNode node, int medicalNumber) {
        if (node == null)
            return null;

        if (medicalNumber == node.patient.medicalNumber) {
            return node.patient;
        } else if (medicalNumber < node.patient.medicalNumber) {
            return searchMedical(node.left, medicalNumber);
        } else {
            return searchMedical(node.right, medicalNumber);
        }
    }

    public void searchByName(String name) {
        boolean found = searchName(root, name);
        if (!found) {
            System.out.println("No patient found with name: " + name);
        }
    }

    private boolean searchName(BSTNode node, String name) {
        if (node == null)
            return false;

        boolean foundLeft = searchName(node.left, name);
        if (node.patient.name.equalsIgnoreCase(name)) {
            System.out.println(node.patient);
            return true;
        }
        boolean foundRight = searchName(node.right, name);

        return foundLeft || foundRight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientBST patientTree = new PatientBST();

        while (true) {
            System.out.println("\n==== Patient Management System ====");
            System.out.println("1. Add Patient");
            System.out.println("2. List All Patients");
            System.out.println("3. Search by Medical Number");
            System.out.println("4. Search by Name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter medical number (integer): ");
                    int medicalNumber = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter condition: ");
                    String condition = scanner.nextLine();
                    System.out.print("Requires operation? (true/false): ");
                    boolean operation = Boolean.parseBoolean(scanner.nextLine());

                    Patient newPatient = new Patient(name, medicalNumber, condition, operation);
                    patientTree.addPatient(newPatient);
                    break;

                case 2:
                    System.out.println("\nList of Patients:");
                    patientTree.listPatients();
                    break;

                case 3:
                    System.out.print("Enter medical number to search: ");
                    int medNo = Integer.parseInt(scanner.nextLine());
                    Patient found = patientTree.searchByMedicalNumber(medNo);
                    if (found != null) {
                        System.out.println("Patient found:\n" + found);
                    } else {
                        System.out.println("No patient found with that medical number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    System.out.println("Search results:");
                    patientTree.searchByName(searchName);
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
