
import java.util.Scanner;

public class Students {

    static class Student {
        int reg_no;
        double cgpa;
        String name;
        int left = -1;
        int right = -1;

    }

    Student[] arr = new Student[50];
    int count = 0;

    public void addStudent(Student student) {
        if (count == 0) {
            arr[count] = student;
            count++;
            return;
        }
        arr[count] = student;
        int i = 0;
        while (true) {
            if (student.reg_no > arr[i].reg_no) {
                if (arr[i].right == -1) {
                    arr[i].right = count;
                    break;
                } else {
                    i = arr[i].right;
                }
            } else {
                if (arr[i].left == -1) {
                    arr[i].left = count;
                    break;
                } else {
                    i = arr[i].left;
                }
            }
        }
        count++;
    }

    public void searchByName(String name) {
        int index = 0;
        while (index != -1 && arr[index] != null) {
            if (arr[index].name.equals(name)) {
                System.out.println("Student found:");
                System.out.println("REG NO: " + arr[index].reg_no);
                System.out.println("CGPA: " + arr[index].cgpa);

                return;
            } else if (name.compareTo(arr[index].name) < 0) {
                index = arr[index].left;
            } else {
                index = arr[index].right;
            }
        }
        System.out.println("Student with Reg NO " + name + " not found.");
    }

    public void displayAgesAscending() {
        inOrderTraversal(0);
    }

    private void inOrderTraversal(int index) {
        if (index == -1 || arr[index] == null) {
            return;
        }
        inOrderTraversal(arr[index].left);
        System.out.print(arr[index].reg_no + " ");
        inOrderTraversal(arr[index].right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Students students = new Students();
        while (true) {

            System.out.println("                                  ");
            System.out.println("1.Add Student. ");
            System.out.println("2.Inorder Traversal.");
            System.out.println("3.Search Student by Name. ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    System.out.print("Enter reg_no: ");
                    s.reg_no = sc.nextInt();
                    System.out.print("Enter Name: ");
                    s.name = sc.next();
                    System.out.print("Enter cgpa: ");
                    s.cgpa = sc.nextDouble();

                    students.addStudent(s);
                    break;
                case 2:
                    students.displayAgesAscending();
                    break;

                case 3:

                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    students.searchByName(name);
                    break;
                default:
                    System.out.println("Invalid input..");
                    break;
            }
        }
    }
}