
import java.util.*;
public class StudentData {
	
	
	
	
	String [] name= new String [10];
	int [] age=	new int[10];
	double [] cgpa=new double[10];
	int count=0;
	
	
	
	
	void growArray()	{
		String [] Nname= new String [name.length*2];
		int [] Nage=	new int[age.length*2];
		double [] Ncgpa=new double[cgpa.length*2];
		
		
		for(int i=0;i<count;i++) {
			
			Nname[i]=name[i];
			Nage[i]=age[i];
			Ncgpa[i]=cgpa[i];
			
			
			
		}
		Nname=name;
		Nage=age;
		Ncgpa=cgpa;
		
	}
	
	
	
	void insert(String name,int age,double cgpa) {
		
		
		if(count>=name.length())
		{
				growArray()	;
			}
			    
		
		this.name[count]=name;
		this.age[count]=age;
		this.cgpa[count]=cgpa;
		count++;
		
		}
	void display() {
		
		if(count==0) {
			
			System.out.println("Array is empty");
		}
		
		
		
		for( int i=0;i<count;i++) {
			
			System.out.println("Student name: "+name[i]);
			System.out.println("Student age: "+age[i]);
			System.out.println("Student cgpa: "+cgpa[i]);
		}
		
		
	}
	
	void insertAtPos(int pos ,String name,int age,double cgpa	) {
		
		if(count>=name.length()) {
			growArray()	;
		}
		
		for(int i=pos;i>count;i--) {
		
			
			
			
			
		}
		
		
		
		
	}
		
		
	
	
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String []args) {
		
		Scanner sc=new Scanner(System.in);
		StudentData sd=new StudentData();
		
		System.out.println("Enter Student Name:");
		String name=sc.nextLine()	;
		
		System.out.println("Enter Student Age:");
		int age=sc.nextInt()	;
		
		System.out.println("Enter Student Cgpa:");
		double cgpa=sc.nextDouble()	;
		
		
		sd.insert(name, age, cgpa);
		sd.display();
		
		
		
		
		
		
		
	}
}