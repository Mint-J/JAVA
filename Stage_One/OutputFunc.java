package com.TestDemo_2;

import java.io.*;

public class OutputFunc {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try (Net n = new Net()){
			n.info();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		File file = new File("C:"+File.separator+"Game"
				+File.separator+"JAVA"+File.separator+"ml.txt");
		if (!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		
		OutputStream output = null;
		try {
			output = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String s = "ABCDEFG";
		byte data[] = s.getBytes();
		try {
			output.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class Net implements AutoCloseable{
	@Override
	public void close() throws Exception{
		System.out.println("Close");
	}
	public void info(){
		System.out.println("Info exists");
	}
}
