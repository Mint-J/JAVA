package Stage_One;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

public class PrintFunc {
	public static void main(String args[]) throws Exception{
		String s = "abcdefg";
		InputStream i = new ByteArrayInputStream(s.getBytes());
		OutputStream o = new ByteArrayOutputStream();
		int temp = 0;
		while ((temp = i.read()) != -1){
			o.write(Character.toUpperCase(temp));
		}
		System.out.println(o);
		i.close();
		o.close();

		File fileA = new File("C:"+File.separator+"Game"
				+File.separator+"JAVA"+File.separator+"ml.txt");
		File fileB = new File("C:"+File.separator+"Game"
				+File.separator+"ml.txt");
		InputStream sa = new FileInputStream(fileA);
		InputStream sb = new FileInputStream(fileB);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		while ((temp = sa.read()) != -1){
			output.write(temp);
		}
		while ((temp = sb.read()) != -1){
			output.write(temp);
		}
		byte data[] = output.toByteArray();
		output.close();
		sa.close();
		sb.close();
		System.out.println(new String(data));
		
		try {
			Integer.parseInt("abc");
		} catch (Exception e){
			System.err.println(e);
		}
		
		InputStream input = System.in;
		byte db[] = new byte[1024];
		System.out.println("Input:");
		int len = input.read(db);
		System.out.println(new String(data , 0 , len));
	}
}
