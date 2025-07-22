
import java.util.Scanner;

// Queue.java
// This is a simple implementation of a queue data structure in Java.
public class Queue {

    int data[] = new int[5];

    int front = 0;
    int rear = -1;
    int capacity = data.length;

    boolean isEmpty() {
        return false;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    void enqueue(int v) {
        if (isFull()) {
            System.out.println("Can't add more data");
        }

        rear++;
        data[rear] = v;

    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("No Data found To deleted.");
        }
        int removed = data[front];
        front++;

        return removed;
    }

    public static void main(String[] args) {

        Queue que = new Queue();
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("Press 1 to Insert in Queue");
            System.out.println("Press 2 to Remove from Queue");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Elements to insert (Int)");
                    int v = input.nextInt();
                    que.enqueue(v);
                }

                case 2 -> {
                    que.dequeue();
                    System.out.println("Element Deleted");
                }

                default -> {
                }
            }
        }
    }

}
