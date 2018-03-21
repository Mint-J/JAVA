package Stage_One;

public class HelloWorld {

	//This file is practice for JAVA Freshman Knowledge!
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		// The file is updated for the JAVA learning
		// Though a mess, it trains me for irrepeated grammar
			System.out.println("HelloWorld!");
			
			int five = 5;
			int ten = 10;
			//Forced conversion
			double fived = (double)five;
			//Self-add system
			double sum = ++five + ten;
			System.out.println(fived);
			System.out.println((double)five);
			System.out.println("Sum: " + sum);
			int max = five > ten ? five : ten;
			System.out.println(max);
			
			int numA = 10;
			int numB = 3;
			//Remains after devision
			System.out.println(numA % 2);
			System.out.println(numB % 2);
			
			int numC = 10;
			//Boolean operation system
			if (numC % 2 == 0){
				System.out.println("It is even.");
			} else {
				System.out.println("It is odd.");
			}
			
			if((five==ten)&&(five/ten==0)){
				System.out.println(five);
			} else {
				System.out.println(ten);
			}			
			
			System.out.println();
			System.out.println();
			
			for(int x=1;x<=9;x++){
				for(int y=1;y<=x;y++){
					System.out.print(x + "*" + y + "=" + x*y + "\t");
				} System.out.println();
			}
	}

}
