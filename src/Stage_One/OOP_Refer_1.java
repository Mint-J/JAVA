package Stage_One;

public class OOP_Refer_1 {
	
	public static void main(String args[]){
		run();
	}
	
	public static void run(){
		
		Dept dept = new Dept(16 , "Computer Science" , "Canada");
		Employ ea = new Employ(3849, "Tim" , "Art Designer" , 30000);
		Employ eb = new Employ(2479, "Harry" , "Manager" , 50000);
		Employ ec = new Employ(5739, "Jason" , "CEO" , 300000);
		
		ea.setMgr(eb);
		eb.setMgr(ec);
		
		ea.setDept(dept);
		eb.setDept(dept);
		ec.setDept(dept);
		
		dept.setEmploy(new Employ[]{ea , eb , ec});
		
		System.out.println(ea.getInfo());
		System.out.println("\t|-" + ea.getDept().getInfo());
		System.out.println("\t|-" + ea.getMgr().getInfo());
		System.out.println(dept.getInfo());
		
		for(int x = 0 ; x < dept.getEmploy().length ; x++){
			System.out.println("\t|-" + dept.getEmploy()[x].getInfo());
			if (dept.getEmploy()[x].getMgr() != null){
				System.out.println("\t\t|-" + dept.getEmploy()[x].getMgr().getInfo());
			}
		}
	}
	
}

class Dept{
	private int deptno;
	private String dname;
	private String loc;
	private Employ[] emp;
	
	public Dept(int no , String name , String loc){
		this.deptno = no;
		this.dname = name;
		this.loc = loc;
	}
	
	public void setEmploy(Employ[] employs){
		this.emp = employs;
	}
	
	public Employ[] getEmploy(){
		return this.emp;
	}
	
	public void setDeptno(int no){
		this.deptno = no;
	}
	
	public int getDeptno(){
		return this.deptno;
	}
	
	public void setDname(String name){
		this.dname = name;
	}
	
	public String getDname(){
		return this.dname;
	}
	
	public void setLoc(String loc){
		this.loc = loc;
	}
	
	public String getLoc(){
		return this.loc;
	}
	
	public String getInfo(){
		return "Deptno: " + deptno + " | Deptname: " + dname + " | Loc: " + loc;
	}
	
	
}

class Employ{
	
	private int empno;
	private String ename;
	private String job;
	private double sala;
	private Employ mgr;
	private int deptno;
	private Dept dept;
	
	public Employ(int no , String name , String job , double sala){
		this.empno = no;
		this.ename = name;
		this.job = job;
		this.sala = sala;
	}
	
	public void setDept(Dept dept){
		this.dept = dept;
	}
	
	public Dept getDept(){
		return this.dept;
	}
	
	public void setEname(String name){
		this.ename = name;
	}
	
	public String getEname(){
		return this.ename;
	}
	
	public void setEmpno(int no){
		this.empno = no;
	}
	
	public int getEmpno(){
		return this.empno;
	}
	
	public void setJob(String job){
		this.job = job;
	}
	
	public String getJob(){
		return this.job;
	}
	
	public void setSala(double sala){
		this.sala = sala;
	}
	
	public double getSala(){
		return this.sala;
	}
	
	public void setMgr(Employ ec){
		this.mgr = ec;
	}
	
	public Employ getMgr(){
		return this.mgr;
	}
	
	public void setDeptno(int no){
		this.deptno = no;
	}
	
	public int getDeptno(){
		return this.deptno;
	}
	
	
	public String getInfo(){
		return "Empno: " + empno + " | ename: " + ename + " | Job: " + job
				 + " | Sala: " + sala;
	}
}