package com.TestDemo_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputFunc {

	public static void main(String args[]) throws Exception{
		File file = new File("C:"+File.separator+"Game"
				+File.separator+"JAVA"+File.separator+"ml.txt");
		if (file.exists()){
			InputStream input = new FileInputStream(file);
			byte data[] = new byte[1024];
			int len = input.read(data);
			input.close();
			System.out.println(new String(data , 0 , len));
		}
		
		if (file.exists()){
			InputStream input = new FileInputStream(file);
			int temp = 0;
			int foot = 0;
			byte data[] = new byte[1024];
			while ((temp = input.read()) != -1){
				data[foot ++] = (byte) temp;
			}
			System.out.println(new String(data , 0 ,foot));
		}
	}
}
