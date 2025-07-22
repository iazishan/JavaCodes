import java.util.Scanner;

public class CircularQueue {

    int[] id = new int[10];

    int rear = -1;
    int front = -1;
    int capacity = id.length;

    boolean isFull() {

        return (rear + 1) % capacity == front;
    }

    boolean isEmpty() {
        return front == -1;

    }

    void enqueue(int v) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            if (front == -1) {
                front = 0;
            }

            rear = rear + 1 % capacity;
            id[rear] = v;
        }
    }

    int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            int value = id[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return value;
        }
    }

    void diplay() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Ticket In the Queue:    ");
            for (int i = front; i <= rear; i++) {
                System.out.println("Ticket ID: " + id[i]);
                System.out.println("---------------------");
                System.out.println("                    ");
            }
        }
    }

    public static void main(String[] args) {

        CircularQueue queue = new CircularQueue();

        while (true) {
            System.out.println("Circular QUeUE Implementation");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Ticket ID to add:");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.diplay();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}
