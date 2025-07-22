import java.util.*;

public class CustomerCallSupport {

    int id;
    String name;
    String issue;

    static Stack<CustomerCallSupport> stack = new Stack<>();

    CustomerCallSupport(int id, String name, String issue) {
        this.id = id;
        this.name = name;
        this.issue = issue;
    }

    static void addCustomer(String name, String issue) {
        int id = stack.size() + 1;
        CustomerCallSupport customer = new CustomerCallSupport(id, name, issue);
        stack.push(customer);
        System.out.println("Added: " + customer.display());
    }

    static void resolveQuery() {
        if (!stack.isEmpty()) {
            CustomerCallSupport customer = stack.pop();
            System.out.println("Resolved: " + customer.display());
        } else {
            System.out.println("No customers to resolve.");
        }
    }

    static void displayAll() {
        if (stack.isEmpty()) {
            System.out.println("No customers in the stack.");
        } else {
            System.out.println("Customers in the stack:");
            for (CustomerCallSupport customer : stack) {
                System.out.println(customer.display());
            }
        }
    }

    private String display() {
        return "Customer ID: " + id + ", Name: " + name + ", Issue: " + issue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Press 1 to add customer");
            System.out.println("Press 2 to view issues");
            System.out.println("Press 3 to resolve query");
            System.out.println("Press 4 to exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter customer name:");
                    String name = sc.nextLine();
                    System.out.println("Enter issue:");
                    String issue = sc.nextLine();
                    addCustomer(name, issue);
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    resolveQuery();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
