
import java.util.*;

public class DynamicArray {
	
	Scanner sc = new Scanner(System.in);
	int size = 5;
	String[] name = new String[size];
	String[] aridNumber = new String[size];
	double[] grade = new double[size];
	int count = 0;
	
    public void insertSpecificPosition(int pos, String n, String arid, double g) {
        if (pos < 0 || pos > count) {
            System.out.println("Invalid position! Must be between 0 and " + count);
            return;
        }
    
        if (count >= name.length) {
            growArray();
        }
    
        for (int i = count; i > pos; i--) {
            name[i] = name[i - 1];
            aridNumber[i] = aridNumber[i - 1];
            grade[i] = grade[i - 1];
        }
    
        name[pos] = n;
        aridNumber[pos] = arid;
        grade[pos] = g;
        count++;
    }
	
	public void insertEnd(String n, String arid, double g) {
		if(count >= name.length) {
			growArray();
		}
		name[count] = n;
		aridNumber[count] = arid;
		grade[count] = g;
		count++;
	}
	
	public void insertStart(String n, String arid, double g) {
		if(count >= name.length) {
			growArray();
		}
		for(int i = count; i > 0; i--) {
			name[i] = name[i - 1];
			aridNumber[i] = aridNumber[i - 1];
			grade[i] = grade[i - 1];
		}
		name[0] = n;
		aridNumber[0] = arid;
		grade[0] = g;
		count++;
	}
	
    public void growArray() {
        int newSize = name.length * 2; // more efficient growth
        String[] tempName = new String[newSize];
        String[] tempArid = new String[newSize];
        double[] tempGrade = new double[newSize];
    
        for (int i = 0; i < name.length; i++) {
            tempName[i] = name[i];
            tempArid[i] = aridNumber[i];
            tempGrade[i] = grade[i];
        }
    
        name = tempName;
        aridNumber = tempArid;
        grade = tempGrade;
    }
	
    public void deleteStart() {
        if (count == 0) {
            System.out.println("Array is empty");
        } else {
            for (int i = 0; i < count - 1; i++) {
                name[i] = name[i + 1];
                aridNumber[i] = aridNumber[i + 1];
                grade[i] = grade[i + 1];
            }
            count--;
            System.out.println("Data Deleted.");
        }
    }
	
	public void deleteAtEnd() {
		if(count == 0) {
			System.out.println("Array is empty");
		} else {
			count--;
			System.out.println("Element deleted!");
		}
	}
	
	public void BackShift(int pos) {
		for(int i = pos; i < count - 1; i++) {
			name[i] = name[i + 1];
			aridNumber[i] = aridNumber[i + 1];
			grade[i] = grade[i + 1];
		}
	}
	
	public void deleteAtIndex(String arid) {
		if(count == 0) {
			System.out.println("Array is empty");
		} else {
			int pos = search(arid);
			if(pos == -1) {
				System.out.println("Element not found!");
			} else {
				BackShift(pos);
				count--;
			}
		}
	}
	
	public int search(String arid) {
		int index = -1;
		for(int i = 0; i < count; i++) {
			if(aridNumber[i].equals(arid)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void DisplayData() {
		if(count == 0) {
			System.out.println("Array is empty!");
		} else {
			System.out.println("***** Displaying Data ******");
			for(int i = 0; i < count; i++) {
				System.out.println("Name: " + name[i] + ", ARID: " + aridNumber[i] + ", Grade: " + grade[i]);
			}
			System.out.println("");
		}
	}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DynamicArray db = new DynamicArray();

        while (true) {
            System.out.println("\n----- Student Database Menu -----");
            System.out.println("1. Insert at Start");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Specific Position");
            System.out.println("4. Delete from Start");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete at Specific Index");
            System.out.println("7. Search Student");
            System.out.println("8. Display All Students");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter ARID Number: ");
                    String arid1 = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade1 = sc.nextDouble();
                    db.insertStart(name1, arid1, grade1);
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter ARID Number: ");
                    String arid2 = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade2 = sc.nextDouble();
                    db.insertEnd(name2, arid2, grade2);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Enter ARID Number: ");
                    String arid3 = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade3 = sc.nextDouble();
                    db.insertSpecificPosition(pos, name3, arid3, grade3);
                    break;
                case 4:
                    db.deleteStart();
                    break;
                case 5:
                    db.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter ARID Number to Delete: ");
                    String aridToDelete = sc.nextLine();
                    db.deleteAtIndex(aridToDelete);
                    break;
                case 7:
                    System.out.print("Enter ARID Number to Search: ");
                    String aridSearch = sc.nextLine();
                    int index = db.search(aridSearch);
                    if (index != -1) {
                        System.out.println("Student found: " + db.name[index] + ", " + db.aridNumber[index] + ", " + db.grade[index]);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 8:
                    db.DisplayData();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}