package Stage_One;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

public class BufferedR_Scanner {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {
			String s = br.readLine();
			if (s.matches("\\d{1,3}")) {
				System.out.println("Age: " + Integer.parseInt(s));
				flag = false;
			} else {
				System.out.println("ERROR");
			}
		}
		
		Scanner scan = new Scanner(new FileInputStream(new File("C:"+File.separator+"Game"
				+File.separator+"JAVA"+File.separator+"ml.txt")));
		scan.useDelimiter("\n");
		if (scan.hasNext()){
			System.out.println(scan.next());
		}
		scan.close();
		
	}

}
