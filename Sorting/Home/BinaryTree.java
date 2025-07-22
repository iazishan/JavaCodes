
import java.util.Scanner;

public class BinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public void displayPosition(int value) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        if (root.data == value) {
            System.out.println(value + " is the root node.");
            return;
        }
        Node current = root;
        while (current != null) {
            if (value < current.data) {
                if (current.left != null && current.left.data == value) {
                    System.out.println(value + " is on the left side of " + current.data);
                    return;
                }
                current = current.left;
            } else if (value > current.data) {
                if (current.right != null && current.right.data == value) {
                    System.out.println(value + " is on the right side of " + current.data);
                    return;
                }
                current = current.right;
            } else {
                // Should not reach here as root.data == value is already checked
                break;
            }
        }
        System.out.println(value + " not found in the tree.");
    }

    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to insert into the binary tree (type 'exit' to stop):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int data = Integer.parseInt(input);
                tree.insert(data);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        System.out.println("Inorder traversal of the binary tree:");
        tree.inorder();
    }
}
