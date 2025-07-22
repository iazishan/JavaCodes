import java.util.Scanner;

public class Employee {

    String name;
    int eid;
    int age;

    public Employee(String name, int eid, int age) {
        this.name = name;
        this.eid = eid;
        this.age = age;
    }

    static class Heap {

        // Swap helper
        private static void swap(Employee[] emp, int i, int j) {
            Employee temp = emp[i];
            emp[i] = emp[j];
            emp[j] = temp;
        }

        // Min-Heapify
        private static void minHeapify(Employee[] emp, int size, int i) {
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && emp[left].age < emp[smallest].age) {
                smallest = left;
            }
            if (right < size && emp[right].age < emp[smallest].age) {
                smallest = right;
            }
            if (smallest != i) {
                swap(emp, i, smallest);
                minHeapify(emp, size, smallest);
            }
        }

        // Build Min-Heap
        public static void buildMinHeap(Employee[] emp, int size) {
            for (int i = size / 2 - 1; i >= 0; i--) {
                minHeapify(emp, size, i);
            }
        }

        // Min-Heap Sort (Ascending by Age)
        public static void minHeapSort(Employee[] emp, int size) {
            buildMinHeap(emp, size);
            for (int i = size - 1; i > 0; i--) {
                swap(emp, 0, i);
                minHeapify(emp, i, 0);
            }
        }

        // Max-Heapify
        private static void maxHeapify(Employee[] emp, int size, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && emp[left].age > emp[largest].age) {
                largest = left;
            }
            if (right < size && emp[right].age > emp[largest].age) {
                largest = right;
            }
            if (largest != i) {
                swap(emp, i, largest);
                maxHeapify(emp, size, largest);
            }
        }

        // Build Max-Heap
        public static void buildMaxHeap(Employee[] emp, int size) {
            for (int i = size / 2 - 1; i >= 0; i--) {
                maxHeapify(emp, size, i);
            }
        }

        // Max-Heap Sort (Descending by Age)
        public static void maxHeapSort(Employee[] emp, int size) {
            buildMaxHeap(emp, size);
            for (int i = size - 1; i > 0; i--) {
                swap(emp, 0, i);
                maxHeapify(emp, i, 0);
            }
        }
    }

    // Display function
    public static void display(Employee[] emp, int size) {
        System.out.println("Employee Data:");
        for (int i = 0; i < size; i++) {
            if (emp[i] != null)
                System.out.println("Name: " + emp[i].name + ", EID: " + emp[i].eid + ", Age: " + emp[i].age);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = 5; // Change size here
        Employee[] emp = new Employee[size];

        System.out.print("How many Employees you want to add: ");
        int add = sc.nextInt();
        for (int i = 0; i < add; i++) {
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Eid: ");
            int eid = sc.nextInt();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            emp[i] = new Employee(name, eid, age);
        }

        while (true) {
            System.out.println("\n1. Print data in Ascending Order (by Age):");
            System.out.println("2. Print data in Descending Order (by Age):");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int c = sc.nextInt();

            switch (c) {
                case 1 -> {
                    Heap.minHeapSort(emp, add);
                    display(emp, add);
                }
                case 2 -> {
                    Heap.maxHeapSort(emp, add);
                    display(emp, add);
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice.");
            }
        }
    }
}
