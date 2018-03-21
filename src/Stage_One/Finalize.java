package Stage_One;

public class Finalize {
	public static void main(String args[]) throws Exception{
		HumanA h = new HumanA();
		h = null;
		System.gc();
	}
}

class HumanA{
	public HumanA(){
		System.out.println("AAA");
	}
	
	@Override
	protected void finalize() throws Throwable{
		System.out.println("BBB");
		throw new Exception("Exc");
	}
}


