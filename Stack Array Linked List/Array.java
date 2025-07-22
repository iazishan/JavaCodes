
import java.util.*;




// array , linked list, Stack


public class Array {


	int[]arr = new int[10];
	int count =0;
	


	void growArray() {

		int[] temp = new int[arr.length*2];

		for(int i = 0; i<arr.length;i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}


	void insertion(int data) {
        
		if(count>= arr.length) {
			growArray();
		}
		if(arr.length<data)
        {
		arr[count] = data;
		count++;
			
		
        }
	}
	
	void insertAt(int index,int data) {
		if(count>= arr.length) {
			growArray();
		}
		
		for(int i=count; i>index;i--) {
			arr[i] = arr[i-1];
		}
		arr[index] = data;
		count++;
		
	}

	
	void deletion() {
		if(count == 0) {
			System.out.println("Array is already empty!");
		}
		else {
			arr[count-1] =0;
			count--;
			System.out.println("deleted!");
		}
	}
	
	void deleteAT(int num) {
		if(count==0) {
			System.out.println("Array is already empty!");
		}
		else {
			int pos = search(num);
				if(pos != -1) {
					for(int i=pos;i<(count-1);i++) {
						arr[i]=arr[i+1];
						}
					arr[count-1]=0;
					count--;
					System.out.println("Deleted!");
				
				}
				else {
					System.out.println("No data found!");
				}
		}
		}
	
	int search(int v) {
		int index =-1;
		for(int i=0;i<count;i++) {
			if(arr[i] == v) {
				index = i;
			}
		}
		return index;
	}
	
	
	
	
	void display() {
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>0) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println("");
	}
	
	public static void main(String[]args) {
		Array ar = new Array();
//		ar.insertion(15);
//		ar.insertion(20);
//		ar.display();
//		ar.insertAt(1, 17);
//		ar.insertAt(2, 19);
//		ar.display();
//		ar.deleteAT(1);
//		ar.display();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter 1 for insertion data");
			System.out.println("Enter 2 for insertion at Specific index");
			System.out.println("Enter 3 for deletion at last index");
			System.out.println("Enter 4 for deletion at specific index");
			System.out.println("Enter 5 for display");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter num:");
				int n =sc.nextInt();
				ar.insertion(n);
				break;
			}
			case 2:
				System.out.println("Enter num:");
				int n =sc.nextInt();
				System.out.println("Enter index:");
				int n1 =sc.nextInt();
				ar.insertAt(n1, n);
				break;
				
			case 3:
				ar.deletion();
				break;
				
			case 4:
				System.out.println("Enter number that you want to delete:");
				int n11 =sc.nextInt();
				ar.deleteAT(n11);
				break;
				
			case 5:
				ar.display();
				break;
			default:
				System.out.println("Enter a valid option");
			}
			
		}
	}

}