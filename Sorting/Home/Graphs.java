
import java.util.Scanner;

public class Graphs {

    int max = 100;
    private Student[] students = new Student[max];
    private int studentCount = 0;

    private boolean[][] edges = new boolean[max][max];

    public class Student {
        String name;
        int id;
        double gpa;

        Student(String name, int id, double gpa) {
            this.name = name;
            this.id = id;
            this.gpa = gpa;
        }
    }

    public void addNode(String name, int id, double gpa) {
        if (studentCount < max) {
            students[studentCount] = new Student(name, id, gpa);
            studentCount++;
        }
    }

    private int findIndexById(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].id == id)
                return i;
        }
        return -1;
    }

    public void addEdge(int id1, int id2) {
        int i = findIndexById(id1);
        int j = findIndexById(id2);
        if (i != -1 && j != -1) {
            edges[i][j] = true;
            edges[j][i] = true;
        }
    }

    public void displayEdgesOfNode(int id) {
        int i = findIndexById(id);
        if (i == -1) {
            System.out.println("Node not found.");
            return;
        }
        System.out.println("Edges for " + students[i].name + ":");
        for (int j = 0; j < studentCount; j++) {
            if (edges[i][j]) {
                System.out.println("  -> " + students[j].name);
            }
        }
    }

    public void displayEdgeBetween(int id1, int id2) {
        int i = findIndexById(id1);
        int j = findIndexById(id2);
        if (i == -1 || j == -1) {
            System.out.println("Node(s) not found.");
            return;
        }
        if (edges[i][j]) {
            System.out.println("Edge exists between " + students[i].name + " and " + students[j].name);
        } else {
            System.out.println("No edge between " + students[i].name + " and " + students[j].name);
        }
    }

    public void deleteNode(int id) {
        int idx = findIndexById(id);
        if (idx == -1)
            return;
        for (int i = idx; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        students[studentCount - 1] = null;
        for (int i = 0; i < studentCount; i++) {
            for (int j = idx; j < studentCount - 1; j++) {
                edges[i][j] = edges[i][j + 1];
            }
            edges[i][studentCount - 1] = false;
        }
        for (int i = idx; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount; j++) {
                edges[i][j] = edges[i + 1][j];
            }
        }
        for (int j = 0; j < studentCount; j++) {
            edges[studentCount - 1][j] = false;
        }
        studentCount--;
    }

    public void deleteEdge(int id1, int id2) {
        int i = findIndexById(id1);
        int j = findIndexById(id2);
        if (i != -1 && j != -1) {
            edges[i][j] = false;
            edges[j][i] = false;
        }
    }

    public static void main(String[] args) 
    {
        Graphs gragphs = new Graphs();
        Scanner sc = new Scanner(System.in);

        while (true) { 
            System.out.println("1. Add Node: ");
            System.out.println("2. Add Edge: ");
            System.out.println("3. Display Edges of Node: ");
            System.out.println("4. Display Edge Between: ");
            System.out.println("5. Delete Node: ");
            System.out.println("6. Delete Edge: ");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            

     switch (choice) {
               
        case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();    
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();
                    gragphs.addNode(name, id, gpa);
                    System.out.println("Node added successfully.");
                    break;
                
        case 2:
                    System.out.print("Enter ID of first node: ");
                    int id1 = sc.nextInt();
                    System.out.print("Enter ID of second node: ");
                    int id2 = sc.nextInt();
                    gragphs.addEdge(id1, id2);
                    System.out.println("Edge added successfully.");
                    break;



        case 3:
                    System.out.print("Enter ID of the node: ");
                    int nodeId = sc.nextInt();
                    gragphs.displayEdgesOfNode(nodeId);
                    break;



         case 4:
                    System.out.print("Enter ID of first node: ");
                    int firstId = sc.nextInt();
                    System.out.print("Enter ID of second node: ");
                    int secondId = sc.nextInt();
                    gragphs.displayEdgeBetween(firstId, secondId);
                    break;


         case 5:
                    System.out.print("Enter ID of the node to delete: ");
                    int deleteId = sc.nextInt();
                    gragphs.deleteNode(deleteId);
                    System.out.println("Node deleted successfully.");
                    break;

         case 6:
                    System.out.print("Enter ID of first node: ");   
                    int delId1 = sc.nextInt();
                    System.out.print("Enter ID of second node: ");
                    int delId2 = sc.nextInt();
                    gragphs.deleteEdge(delId1, delId2);
                    System.out.println("Edge deleted successfully.");
                    
            }
        }
    }
}
