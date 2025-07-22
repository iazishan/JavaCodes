
import java.util.Scanner;

class Ticket {

    int[] id = new int[10];
    String[] name = new String[10];

    int rear = -1;
    int front = -1;
    int capacity = 5;

    void enqueue(int id, String name) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            this.id[rear] = id;
            this.name[rear] = name;
        }

    }

    void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Ticket removed: " + name[front]);
            front++;
            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Tickets in the queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.println(name[i]);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Ticket Queue Implementation");
        Ticket ticketQueue = new Ticket();
        System.err.println("1. Add Ticket");
        System.err.println("2. Remove Ticket");
        System.err.println("3. Display Tickets");
        System.err.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter ticket ID: ");
                int id = sc.nextInt();
                System.out.println("Enter ticket name: ");
                String name = sc.next();
                ticketQueue.enqueue(id, name);
            }
            case 2 -> ticketQueue.dequeue();
            case 3 -> ticketQueue.display();
            case 4 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice");
        }

    }

}
