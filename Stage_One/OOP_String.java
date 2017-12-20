package com.TestDemo;

public class OOP_String {

	public static void main(String args[]){
		
		run();
	
	}
	
	//Judge whether a string is composed by numbers.
	
	public static boolean isNumber(String temp){
		
		char[] str = temp.toCharArray();
		for(int x = 0 ; x < str.length ; x++){
			if (str[x] > '9' || str[x] < '1'){
				return false;
			}
		}	return true;
		
	}
	
	//toUpperCase the first letter.
	public static String initcap(String temp){
		return temp.substring(0,1).toUpperCase() + temp.substring(1);
	}
	
	
	//Woo! A surprisingly successful attempt!!!
	//For relocate all codes into a new main and run the submain in the chief main.
	
	public static void run(){
		
		String stra = "HELLO";
		String strb = "HELLO";
		String strc = "hello";
		
		System.out.println(stra.equals(strb));
		System.out.println(strb.equals(strc));
		
		char a = stra.charAt(2);
		System.out.println(a);
		
		char[] str = stra.toCharArray();
		for(int x = 0 ; x < str.length ; x++){
			System.out.print(str[x] + "/");
		}	System.out.println();
		
		for(int x = 0 ; x < str.length ; x++){
			str[x] += 32;
			System.out.print(str[x] + "/");
		}	System.out.println();
		
		System.out.println(new String(str,1,2));
		
		String str4 = "1234567890";
		
		if (isNumber(str4)){
			System.out.println("Composited by numbers!");
		} else {
			System.out.println("Not by numbers!");
		}
		
		byte[] data = stra.getBytes();
		for (int x = 0 ; x < data.length ; x++){
			data[x] += 32;
			
		}
		System.out.println(new String(data));
		System.out.println(new String(data,1,3));
		
		System.out.println(strb.equalsIgnoreCase(strc));
		System.out.println(stra.equalsIgnoreCase(strb));
		System.out.println(strb.compareTo(strc));
		
		System.out.println(stra.contains("H"));
		System.out.println(stra.contains(strb));
		System.out.println(stra.indexOf("H"));
		System.out.println(stra.indexOf("ELLO"));
		System.out.println(stra.indexOf("L",3));
		System.out.println(stra.lastIndexOf("L"));
		System.out.println(stra.startsWith("H"));
		
		String resultA = stra.replaceAll("L", "E");
		String resultB = strc.replaceFirst("l","e");
		System.out.println(resultA);
		System.out.println(resultB);
		
		String resultC = stra.substring(3);
		String resultD = stra.substring(0, 2);
		System.out.println(resultC);
		System.out.println(resultD);
		
		String strd = "HELLO WORLD !";
		String result1[] = strd.split(" ");
		for (int x = 0 ; x < result1.length ; x++){
			System.out.print(result1[x] + "/");	
		}	System.out.println();
		
		String stre = "Jason:97|Tim:98|Betty:21";
		String result2[] = stre.split("\\|");
		for (int x = 0 ; x < result2.length ; x++){
			String temp[] = result2[x].split("\\:");
			System.out.println("Name:" + temp[0] + "|" + "Score:" + temp[1]);
		}
		
		String strf = stra.concat(" WORLD!");
		System.out.println(strf);
		System.out.println(stra.toLowerCase());
		System.out.println(strc.toUpperCase());
		
		String strg = strf.concat("      ");
		System.out.println(strg + "]");
		System.out.println(strg.trim() + "]");
		System.out.println(strg.replaceAll(" ", ""));
		
		System.out.println(initcap(strc));
		
	}
}
