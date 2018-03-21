package Stage_One;

public class OOP_Inner{
	public static void main(String args[]){
		new Outer().fun(90);
	}
}

class Outer{
	private String a = "AAAAA";
	
	//"final" key word!
	public void fun(final int no){
		final double b = 99.9;
		class Inner{
			public void print(){
				System.out.println(Outer.this.a.substring(0, 2));
				System.out.println(b);
				System.out.println(no);
			}
		} new Inner().print();
	}
}