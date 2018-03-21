package Stage_One;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {
	public static void main(String args[]) throws Exception{
		long start = System.currentTimeMillis();
		if (args.length != 2){
			System.out.println("ERROE!");
			System.exit(1);
		}
		File inFile = new File(args[0]);
		if (!inFile.exists()){
			System.out.println("Not Exist!");
			System.exit(1);
		}
		File outFile = new File(args[1]);
		if (!outFile.getParentFile().exists()){
			outFile.getParentFile().mkdirs();
		}
		InputStream input = new FileInputStream(inFile);
		OutputStream output = new FileOutputStream(outFile);
		int temp = 0 ;
		byte data[] = new byte[1024];
		while ((temp = input.read(data)) != -1){
			output.write(data, 0, temp);
		}
		input.close();
		output.close();
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start));
	}
}
