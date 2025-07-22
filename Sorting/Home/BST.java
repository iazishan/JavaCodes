
import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice;

        do {
            System.out.println("\n====== Binary Search Tree Menu ======");
            System.out.println("1. Insert a value");
            System.out.println("2. Search for a value");
            System.out.println("3. In-order Traversal");
            System.out.println("4. Pre-order Traversal");
            System.out.println("5. Post-order Traversal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    bst.insert(insertValue);
                    System.out.println("Inserted " + insertValue);
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    boolean found = bst.search(searchValue);
                    System.out.println(found ? "Value found!" : "Value not found.");
                    break;

                case 3:
                    System.out.println("In-order Traversal:");
                    bst.inorder();
                    break;

                case 4:
                    System.out.println("Pre-order Traversal:");
                    bst.preorder();
                    break;

                case 5:
                    System.out.println("Post-order Traversal:");
                    bst.postorder();
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    boolean search(int value) {
        return searchRec(root, value);
    }

    boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.data) {
            return true;
        }
        return value < root.data
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}
