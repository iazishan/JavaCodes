
import java.util.Scanner;

public class Dynamic {

	Scanner sc=new Scanner (System.in);
	int arraySize=0;
	int indexOfArray=0;
	String movieName;
	String movieSong;
	int year;
	int id;
	Dynamic [] array;
	
	
	public void inputOfArraySize() {
		do {
			System.out.println("Enter the Number of Movies you want to add:");
			arraySize=sc.nextInt();
			sc.nextLine();
		}while(arraySize<=0);
	}
	
	public void growArray() {
		Dynamic [] temp=new Dynamic [array.length+1];
         for (int i=0;i<array.length;i++) {
        	 temp=array;
         }
         array=temp;
	}
	public void inputtingdata() {
		inputOfArraySize();
		if(indexOfArray>=arraySize) {
			growArray();
		}
		else {
				System.out.println("Enter Movie Id :");
				array[indexOfArray++].id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Movie Name :");
				array[indexOfArray++].movieName=sc.nextLine();
				System.out.println("Enter Movie Song :");
				array[indexOfArray++].movieSong=sc.nextLine();
				System.out.println("Enter Movie Year :");
				array[indexOfArray++].year=sc.nextInt();
				sc.nextLine();
			}
		}
		
	
	public void forwardShift(int pos) {
		for(int i=indexOfArray;i>pos;i--) {
			array[i]=array[i-1];
		}
	}
	
	
	public void insertAtStart(int id,String name,String song,int year ) {
		if(indexOfArray>=array.length) {
			growArray();
		}else {
			forwardShift(0);
			array[0].movieName=name;
			array[0].movieSong=song;
			array[0].id=id;
			array[0].year=year;
			indexOfArray++;
		}
	}
	
	public void insertAtSpecificPos(int pos,int id,String name,String song,int year ) {
		if(indexOfArray>=array.length) {
			growArray();
		}
		else if(pos > 0 && pos < indexOfArray) {
			forwardShift(pos);
			array[pos].movieName=name;
			array[pos].movieSong=song;
			array[pos].id=id;
			array[pos].year=year;
			indexOfArray++;
		}
	}
	public void insertAtEnd(int id,String name,String song,int year) {
		if(indexOfArray>=arraySize) {
			growArray();
		}else {
		array[indexOfArray].movieName=name;
		array[indexOfArray].movieSong=song;
		array[indexOfArray].id=id;
		array[indexOfArray].year=year;
		indexOfArray++;
		}
	}
	
	public void backShift(int pos) {
		for(int i=indexOfArray;i>pos;i--) {
		array[i]=array[i-1];	
		}
	}
	
	
	public void deleteAtStart() {
		if(indexOfArray==0) {
			System.out.println("Empty Array.......");
		}else {
			backShift(0);
			indexOfArray--;
		}
	}
	public void deleteAtSpecificPos(int pos) {
		if(indexOfArray==0) {
			System.out.println("Empty Array.......");
		}
		else if(pos > 0 && pos < indexOfArray){
			backShift(pos);
			indexOfArray--;
		}
	}
	
	public void deleteAtEnd() {
		if(indexOfArray==0) {
			System.out.println("Empty Array.......");
		}else {
			indexOfArray--;
		}
	}
	
	public void display() {
		System.out.println("Displaying data..........");
		for(int i=0;i<indexOfArray;i++) {
			System.out.println("Movie At index  :" + i);
			System.out.println("Movie Id :" + array[i].id);
			System.out.println("Movie Name :" + array[i].movieName);
			System.out.println("Movie Song :" + array[i].movieSong);
			System.out.println("Movie Year :" + array[i].year);
		}
	}
	
	
	public static void main (String args[]) {
		
   		Scanner sc = new Scanner(System.in);
   		int choice;
   	do {
   	System.out.println("------------   Main menu  ------------");
   	System.out.println("Press 1 to Enter data in Array :");
   	System.out.println("Press 2 to Insert data in Array at Start :");
   	System.out.println("Press 3 to Insert data in Array at End :");
   	System.out.println("Press 4 to Insert data in Array at specific pos :");

   	System.out.println("Press 5 to Delete data in Array at Start :");
   	System.out.println("Press 6 to Delete data in Array at End :");
   	System.out.println("Press 7 to Delete data in Array at specific pos :");
   	System.out.println("Press 8 to Display data :");
   	System.out.println("Enter your choice:");
   	choice=sc.nextInt();
   	sc.nextLine();
   	
   	Dynamic a= new Dynamic();
   	switch(choice) {
   	case 1:
   		a.inputtingdata();
   		break;
   	case 2:
   		a.insertAtStart(1011,"Jutt","Butt",1999);
   		break;
   	case 3:a.insertAtEnd(1077,"King","Kholi",1997);
   		break;
   	case 4:a.insertAtSpecificPos(5,1099,"Fadii","King",1998);
   		break;
   	case 5:
   		a.deleteAtStart();
   		break;
	case 6:
   		a.deleteAtEnd();
   		break;
	case 7:
   		a.deleteAtSpecificPos(5);
   		break;
	case 8:
   		a.display();
   		break;
   	default :
   		System.out.print("Invalid input ! Please Enter choice between 1-9 .");
   		break;
   	}

   	}while(choice > 0 && choice < 9);
 	
   }
}