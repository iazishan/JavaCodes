import java.util.Scanner;

public class Passenger {
    String[] flightNum = new String[5];
    String[] name = new String[5];
    int[] bags = new int[5];

    int rear = -1;
    int front = -1;
    int capacity = 5;

    void enqueue(String flightNum, String name, int nOb) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            this.flightNum[rear] = flightNum;
            this.name[rear] = name;
            this.bags[rear] = nOb;
            System.out.println("Passenger added successfully.");
        }
    }

    void dequeueAll() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("                          ");
            System.out.println("passengers Data Available:");
            for (int i = front; i <= rear; i++) {
                System.out.println("Flight Number: " + flightNum[i] + ", Name: " + name[i] + ", Bags: " + bags[i]);
            }
            System.out.println("                             ");
            System.out.println("Proccessing all passengers...");

            for (int i = front; i <= rear; i++) {
                System.out.println("Name:" + name[i] + ":   Flight Number:"
                        + flightNum[i] + ":   No of Bags:" + bags[i]);
            }
            front = -1;
            rear = -1;
        }
    }

    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Passengers in the queue:");
            for (int i = front; i <= rear; i++) {
                System.out.println("Flight Number: " + flightNum[i] + ", Name: " + name[i] + ", Bags: " + bags[i]);
            }
        }
    }

    void checkCurenntPassemger() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Current Passenger: " + name[front]);
        }
    }

    void checkNextPassenger() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Next Passenger: " + name[front + 1]);
        }
    }

    public static void main(String[] args) {
        Passenger pass = new Passenger();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("                              ");
            System.out.println("Passenger Queue Implementation");
            System.out.println("1. Add Passenger");
            System.out.println("2. Remove All Passengers");
            System.out.println("3. Display Passengers");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Passenger name: ");
                    String name = sc.next();
                    System.out.print("Enter Flight Number: ");
                    String flightNum = sc.next();
                    System.out.print("Enter Total number of bags: ");
                    int nob = sc.nextInt();
                    pass.enqueue(flightNum, name, nob);
                }
                case 2 -> pass.dequeueAll();
                case 3 -> pass.display();

                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
