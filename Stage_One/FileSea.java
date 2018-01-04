package com.TestDemo_2;

import java.io.File;

public class FileSea {
	public static void main(String args[]){
		File file = new File("C:"+File.separator+"Users"
			+File.separator+"XPS13"+File.separator+"Desktop"+File.separator+"JAVA");
		print(file);
	}
	
	public static void print(File file){
		if (file.isDirectory()){
			File result[] = file.listFiles();
			for (int x = 0 ; x < result.length ; x ++){
				print(result[x]);
			}
		}
		System.out.println(file);
	}
	
}
