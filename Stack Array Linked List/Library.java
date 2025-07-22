import java.util.Scanner;
import java.util.Stack;

public class Library {

    int id;
    String name;

    static Stack<Library> stack = new Stack<>();



    Library(int id1, String name1) {
        this.id = id1;
        this.name = name1;
    }



    
    static void addBook(int id, String name) {
        Library book = new Library(id, name);
        stack.push(book);
        System.out.println("Added: " + book.display());
    }

   
    static Library getTopBook() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            System.out.println("The stack is empty.");
            return null;
        }
    }

    static Library getBookById(int id) {
        for (Library book : stack) {
            if (book.id == id) {
                return book;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
        return null;
    }

    static Library getBookByName(String name) {
        for (Library book : stack) {
            if (book.name.equalsIgnoreCase(name)) {
                return book;
            }
        }
        System.out.println("Book with name " + name + " not found.");
        return null;
    }
    String display() {
        if(name == null || name.isEmpty()) {
            return "Book ID: " + id + ", Book Name: Not Available";
        }
        return "Book ID: " + id + ", Book Name: " + name;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nPress 1 to add book");
            System.out.println("Press 2 to get top book");
            System.out.println("Press 3 to get book by id");
            System.out.println("Press 4 to get book by name");
            System.out.println("Press 5 to Display Stack");
            System.out.println("Press 6 to exit");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    addBook(id, name);
                    break;

                case 2:
                    Library topBook = getTopBook();
                    if (topBook != null) {
                        System.out.println("Top Book: " + topBook.display());
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    Library specificBook = getBookById(searchId);
                    if (specificBook != null) {
                        System.out.println("Found Book: " + specificBook.display());
                    }
                    break;

                case 4:
                    System.out.println("Books in Stack:");
                    for (Library book : stack) {
                        System.out.println(book.display());
                    }
                    break;   
                case 5:
                    System.out.println("Books in Stack:");
                    for (Library book : stack) {
                        System.out.println(book.display());
                    }
                    break;      

                case 6:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
