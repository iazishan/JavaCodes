import java.util.Scanner;

public class Queuee {

    // Changed Node to QueueNode and made it an inner class
    private static class QueueNode {
        int age;
        int data;
        QueueNode next;
    }

    QueueNode front = null;
    QueueNode rear = null;

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void enqueue(int data,int age) {
        QueueNode newNode = new QueueNode();
        newNode.data = data;
        newNode.age=age;
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            QueueNode current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queuee q = new Queuee();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                      System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    q.enqueue(element,age);
                }
                case 2 -> {
                    int dequeuedElement = q.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued element: " + dequeuedElement);
                    }
                }
                case 3 -> q.display();
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
