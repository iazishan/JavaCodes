import java.util.Scanner;

class Student {
    String name;
    int regNo;
    double cgpa;

    public Student(String name, int regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
    }

    public String toString() {
        return "Student{name='" + name + "', regNo=" + regNo + ", cgpa=" + cgpa + "}";
    }
}

class Node {
    Student data;
    Node left, right;

    public Node(Student data) {
        this.data = data;
    }
}

class StudentBST {
    private Node root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node root, Student student) 
    {
        if (root == null) return new Node(student);

        if (student.regNo < root.data.regNo)
            root.left = insertRec(root.left, student);

        else if (student.regNo > root.data.regNo)
            root.right = insertRec(root.right, student);

        else
            System.out.println("Student with regNo " + student.regNo + " already exists.");
        return root;
    }

    public Student searchByRegNo(int regNo) {
        Node curr = root;
        while (curr != null) {
            if (regNo == curr.data.regNo) return curr.data;
            
            curr = (regNo < curr.data.regNo) ? curr.left : curr.right;
        }
        return null;
    }

    public void inorder() {
        inorderRec(root);
    }

void postOrder(Node root){
if(root!=null){
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.data);
}
}

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);





        }
    }
}

public class StudentMain    {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentBST bst = new StudentBST();

        while (true) {
            System.out.println("\n1. Add Student\n2. Search by RegNo\n3. Display All\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.print("Enter regNo: ");
                int regNo = scanner.nextInt();
                System.out.print("Enter CGPA: ");
                double cgpa = scanner.nextDouble();
                bst.insert(new Student(name, regNo, cgpa));
            } else if (choice == 2) {
                System.out.print("Enter regNo to search: ");
                int regNo = scanner.nextInt();
                Student found = bst.searchByRegNo(regNo);
                System.out.println(found != null ? "Found: " + found : "Not found.");
            } else if (choice == 3) {
                System.out.println("All students:");
                bst.inorder();
            } else if (choice == 4) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
