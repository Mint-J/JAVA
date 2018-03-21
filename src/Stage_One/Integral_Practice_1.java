package Stage_One;

import java.util.Scanner;

		/*The file is set as WEEKLY EXAM !
		 * It contains knowledge about Variables, Class, 
		 * Main, Regional Management, Array, I/O, and dir/indir Order;*/

public class Integral_Practice_1 {
	
	public static void main(String args[]){
		
		/*Import and set Scanner, set Person to book space.
		 * Import uses' name, age, and gender.
		 * Use getInfo() function to print text.*/
		
		Scanner scn = new Scanner(System.in);
		
		Person ps = new Person();
		
		System.out.println("Please enter name: ");
		String pn = scn.next();
		System.out.println("Please enter age: ");
		int pa = scn.nextInt();
		System.out.println("Please enter gender: ");
		String pg = scn.next();
		ps.setName(pn);
		ps.setAge(pa);
		ps.setGender(pg);
		ps.getInfo(pn, pa, pg);
		

		
		// Dir/Indirly sort given numbers.
		
		System.out.println("Please randomly enter 5 integers: ");
		
		int arr[] = new int[]{0,0,0,0,0};
		for (int x =0; x < 5 ; x++){
			int temp = scn.nextInt();
				if(temp == 520){
					break;
				} else {
					arr[x] = temp;
			}
		}
		
		dirSort(arr);
		printSort(arr);
		indirSort(arr);
		printSort(arr);
		
	}
	
	
	public static void dirSort(int arr[]){
		
		//Sort ascendingly.
		
		for (int x=0; x < arr.length ; x++){
			for (int y=0 ; y < arr.length - 1 ; y++){
				if(arr[y] > arr[y+1]){
					int t = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = t;
				}
			}
		}
	}
	
	public static void indirSort(int arr[]){
		
		//Sort descendingly.
		
		for (int x=0; x < arr.length ; x++){
			for (int y=0 ; y < arr.length - 1 ; y++){
				if(arr[y] < arr[y+1]){
					int t = arr[y+1];
					arr[y+1] = arr[y];
					arr[y] = t;
				}
			}
		}
	}
	
	public static void printSort(int arr[]){
		
		//Print sorted numbers according to categories.
		
		if (arr[0] < arr[1]){
			System.out.print("Sort ascending: ");
			for (int x=0 ; x < arr.length ; x++){
				System.out.print(arr[x] + "¡¢");
			}   
		    	System.out.println();
		}
		
		if (arr[0] > arr[1]){
			System.out.print("Sort descending: ");
			for (int x=0 ; x < arr.length ; x++){
				System.out.print(arr[x] + "¡¢");
			}   
		    	System.out.println();
		}
		
	}
}

class Person{
	
	String name;
	int age;
	String gender;
	
	public void setName(String n){
		name = n;
	}
	
	public void setAge(int a){
		age = a;
	}
	
	public void setGender(String g){
		gender = g;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public void getInfo(String n, int a, String g){
		System.out.println("Welcome Back! " + n);
		System.out.println("Age: " + a + " Gender: " + g);
	}
}
