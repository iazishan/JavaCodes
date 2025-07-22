class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Node class for adjacency list
class Node {
    int vertex;
    int weight;
    Node next;

    public Node(int vertex, int weight, Node next) {
        this.vertex = vertex;
        this.weight = weight;
        this.next = next;
    }
}

public class Graph {
    private int vertices;
    private Node[] adjList;
    private Student[] students;

    public Graph(int v) {
        vertices = v;
        adjList = new Node[v];
        students = new Student[v];
    }

    // Add a student at a specific index
    public void addStudent(int index, String name, int age) {
        students[index] = new Student(name, age);
    }

    // Add edge (undirected)
    public void addEdge(int src, int dest, int weight) {
        adjList[src] = new Node(dest, weight, adjList[src]);
        adjList[dest] = new Node(src, weight, adjList[dest]);
    }

    // Print the graph
    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            Node temp = adjList[i];
            while (temp != null) {
                System.out.print("-> (" + temp.vertex + ", w:" + temp.weight + ") ");
                temp = temp.next;
            }
            System.out.println();
        }
        System.out.println("\nStudents:");
        for (int i = 0; i < vertices; i++) {
            if (students[i] != null) {
                System.out.println(i + ": " + students[i].name + ", Age: " + students[i].age);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addStudent(0, "Alice", 20);
        g.addStudent(1, "Bob", 21);
        g.addStudent(2, "Charlie", 19);
        g.addStudent(3, "Diana", 22);
        g.addStudent(4, "Eve", 20);

        g.addEdge(0, 1, 1);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(1, 4, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 4, 1);

        g.printGraph();
    }
}
