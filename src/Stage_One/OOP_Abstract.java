package Stage_One;

public class OOP_Abstract {
	public static void main(String args[]){
		fun(new Robot());
		fun(new Human());
		fun(new Pig());
	}
	
	public static void fun(Action act){
		act.command(Action.EAT);
		act.command(Action.SLEEP);
		act.command(Action.WORK);
	}
}

abstract class Action{
	
	public final static int EAT = 1;
	public final static int SLEEP = 2;
	public final static int WORK = 3;
	
	public void command(int no){
		switch(no){
		case EAT:
			this.eat();
			break;
		case SLEEP:
			this.sleep();
			break;
		case WORK:
			this.work();
			break;
		}
	}
	
	public abstract void eat();
	public abstract void sleep();
	public abstract void work();
}

class Human extends Action{
	public void eat(){
		System.out.println("Human Eat");
	}
	
	public void sleep(){
		System.out.println("Human sleep");
	}
	
	public void work(){
		System.out.println("Human work");
	}
}

class Robot extends Action{
	public void eat(){
		System.out.println("Robot charges");
	}
	
	public void sleep(){
		
	}
	
	public void work(){
		System.out.println("Robot works");
	}
}

class Pig extends Action{
	public void eat(){
		System.out.println("Pig eats");
	}
	
	public void sleep(){
		System.out.println("Pig sleeps");
	}
	
	public void work(){
		System.out.println("Pig works");
	}
}