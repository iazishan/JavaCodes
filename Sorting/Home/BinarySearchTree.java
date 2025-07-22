import java.util.Scanner;

public class BinarySearchTree {

    public class Student {
        int id;
        int age;
        float cgpa;
        String city;
        int left = -1;
        int right = -1;

        Student(int id, int age, float cgpa, String city) {
            this.id = id;
            this.age = age;
            this.cgpa = cgpa;
            this.city = city;
        }
    }

    Student[] arr = new Student[5];
    int count = 0;
    int rootIndex = -1;

    void addStudent(Student s) {
        if (count == arr.length) {
            System.out.println("Array full!");
        }

        arr[count] = s;

        if (rootIndex == -1) {
            rootIndex = count;
        } else {
            int current = rootIndex;
            while (true) {
                if (s.age < arr[current].age) {
                    if (arr[current].left == -1) {
                        arr[current].left = count;
                        break;
                    } else {
                        current = arr[current].left;
                    }
                } else {
                    if (arr[current].right == -1) {
                        arr[current].right = count;
                        break;
                    } else {
                        current = arr[current].right;
                    }
                }
            }
        }

        count++;
        System.out.println("Data Added!");
    }

    public void SearchByAge(int sAge) {
        if (count == 0) {
            System.out.println("Array is Empty!");
        } else {
            boolean found = true;
            int i = 0;
            while (i != count) {
                if (arr[i].age == sAge) {

                    System.out.println("ID: " + arr[i].id);
                    System.out.println("Age: " + arr[i].age);
                    System.out.println("CGPA: " + arr[i].cgpa);
                    System.out.println("City: " + arr[i].city);
                    found = false;
                }
                if (arr[i].age < sAge) {
                    i = arr[i].right;
                } else {
                    i = arr[i].left;
                }
            }
            if (found) {
                System.out.println("Not Found!");
            }
        }
    }

    public void display() {
        if (count == 0) {
            System.out.println("Tree is empty!");
        } else {
            System.out.println("In-order:");
            inOrder(rootIndex);
        }
    }

    private void inOrder(int index) {
        if (index == -1)
            return;
        inOrder(arr[index].left);
        System.out.println("ID: " + arr[index].id);
        System.out.println("Age: " + arr[index].age);
        System.out.println("CGPA: " + arr[index].cgpa);
        System.out.println("City: " + arr[index].city);
        inOrder(arr[index].right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            System.out.println("1.Add Student");
            System.out.println("2.Search Student by age");
            System.out.println("3.Display");
            System.out.println("4.exit");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    System.out.print("Enter ID: ");
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter CGPA: ");
                    float cgpa = Float.parseFloat(sc.nextLine());
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    BinarySearchTree.Student student = bst.new Student(id, age, cgpa, city);
                    bst.addStudent(student);
                    break;
                }
                case 2: {
                    System.out.print("Enter Age to Search: ");
                    int age = sc.nextInt();
                    bst.SearchByAge(age);
                    break;
                }
                case 3: {
                    bst.display();
                    break;
                }
                case 4: {
                    System.out.println("Exiting.");
                    return;
                }

            }
        }
    }

}
