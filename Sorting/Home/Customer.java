import java.util.Scanner;

public class Customer {

    queue[] queue = new queue[10];
    int rear = -1;
    int front = 0;
    int capacity = queue.length;

    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    void placeOrder(String Customername, String drink, int Oid) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot place order.");
            return;
        }
        rear++;
        queue[rear] = new queue();
        queue[rear].Customername = Customername;
        queue[rear].drink = drink;
        queue[rear].Oid = Oid;
    }

    queue dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Is Empty");
        }

        queue next = queue[front++];
        return next;

    }

    queue peek() {
        if (isEmpty()) {
            System.out.println("Queue Is Empty");
        }

        queue current = queue[front];
        return current;

    }

    void serveOrder() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No orders to serve.");
            return;
        }
        System.out.println("                             ");
        System.out.println("Serving To Current Customer:");

        queue curr = peek();
        System.out.println("Customer Name: " + curr.Customername);
        System.out.println("Customer ID: " + curr.Oid);
        System.out.println("Customer Drink: " + curr.drink);

        System.out.println("                         ");
        System.out.println("Serving To Next Customer:");

        queue next = dequeue();
        System.out.println("Customer Name: " + next.Customername);
        System.out.println("Customer ID: " + next.Oid);
        System.out.println("Customer Drink: " + next.drink);

    }

    void viewPendingOrders() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No pending orders.");
            return;
        }
        System.out.println("------Pending Orders--------");

        for (int i = front; i <= rear; i++) {
            System.out.println("Customer Name: " + queue[i].Customername);
            System.out.println("Drink: " + queue[i].drink);
            System.out.println("Order ID: " + queue[i].Oid);
        }
    }

    void cancelOrder(int id) {
        if (isEmpty()) {
            System.out.println("Queue is empty.No Pending orders.");
        } else {
            for (int i = front; i <= rear; i++) {
                if (queue[i].Oid == id) {
                    System.out.println("Order with ID " + id + " has been cancelled.");
                    for (int j = i; j < rear; j++) {
                        queue[j] = queue[j + 1];
                    }
                    rear--;
                    return;
                }
            }
            System.out.println("Order with ID " + id + " not found.");

        }

    }

    void searchByName(String name) {
        if (isEmpty()) {
            System.out.println("Queue is empty.No Pending orders.");
        } else {
            for (int i = front; i <= rear; i++) {
                if (queue[i].Customername.equals(name)) {
                    System.out.println("Order with ID " + queue[i].Oid + " found.");
                    return;
                }
            }
            System.out.println("Order with ID " + name + " not found.");
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer();

        while (true) {

            System.err.println("                                           ");
            System.err.println("***************Main Order******************");
            System.out.println("press 1 to Place Order");
            System.out.println("press 2 to Serve Order");
            System.out.println("press 3 to View Pending Orders");
            System.out.println("press 4 to Cancel Orders");
            System.out.println("press 5 to Search By Name");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Drink: ");
                    String drink = scanner.next();
                    System.out.print("Enter Order ID: ");
                    int oid = scanner.nextInt();
                    customer.placeOrder(name, drink, oid);
                }
                case 2 -> customer.serveOrder();
                case 3 -> customer.viewPendingOrders();
                case 4 -> {
                    System.out.print("Enter Order ID to cancel: ");
                    int id = scanner.nextInt();
                    customer.cancelOrder(id);
                }
                case 5 -> {
                    System.out.print("Enter Customer Name to search: ");
                    String name = scanner.next();
                    customer.searchByName(name);
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }

        }
    }

}

class queue {

    String Customername;
    String drink;
    int Oid;

}
