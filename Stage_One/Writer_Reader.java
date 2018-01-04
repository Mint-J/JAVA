package com.TestDemo_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Writer_Reader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:"+File.separator+"Game"
				+File.separator+"JAVA"+File.separator+"ml.txt");
		if (!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		Writer w = null;
		try {
			w = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "abcd";
		try {
			w.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
