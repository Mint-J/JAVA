package Stage_One;

import java.util.Scanner;

public class T_ScannerInput {
	public static void main(String args[]){
		
		Scanner scn = new Scanner(System.in);
		
		while(true){
			String temp = scn.nextLine();
				if(temp.trim().equals("exit")){
					return;
				}
			System.out.println("Your Input is: " + temp);;
		}
	}
}
