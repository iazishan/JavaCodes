
import java.util.Scanner;

public class Employee {

    public int[] arr;

    public void addEmployee(int val) {
        if (arr == null) {
            arr = new int[100];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = -1;
            }
        }
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == -1) {
                arr[i] = val;
                return;
            }
            if (arr[i] == val) {
                System.out.println("Employee with ID " + val + " already exists.");
                return;
            }
            if (val < arr[i]) {
                i = 2 * i + 1;
            } else {
                i = 2 * i + 2;
            }

        }
        System.out.println("Employee array is full, cannot add more employees.");
    }

    public void searchEmp(int id) {
        if (arr == null) {
            System.out.println("No Employee Data Stored");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == id) {
                System.out.println("Employee with ID " + id + " found at index " + i);
                return;
            }
        }

        System.out.println("Employee with ID " + id + " not found.");
    }

    public void inOrderTraversal() {
        if (arr == null) {
            System.out.println("No Data Stored");
        } else {
            setValuesBy(0);
            System.out.println();
        }
    }

    private void setValuesBy(int index) {
        if (index >= arr.length || arr[index] == Integer.MIN_VALUE) {
            return;
        }
        setValuesBy(2 * index + 1);
        System.out.print(arr[index] + " ");
        setValuesBy(2 * index + 2);
    }

    public static void main(String[] args) {

        Employee emp = new Employee();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("                                         ");
            System.out.println("|***************************|");
            System.out.println(" 1>   To add Employee: ");
            System.out.println(" 2>   To Search Employee: ");
            System.out.println(" 3>   Inorder Traversal: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {

                    System.out.println("Enter Employee Id: ");
                    int id = sc.nextInt();
                    emp.addEmployee(id);
                }
                case 2 -> {

                    System.out.println("Enter Employee Id: ");
                    int target = sc.nextInt();
                    emp.searchEmp(target);

                }
                case 3 -> {
                    System.out.println("InOrder Traversal");

                    emp.inOrderTraversal();

                }

            }
        }
    }

}
