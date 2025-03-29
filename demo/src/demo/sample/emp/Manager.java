package demo.sample.emp;

public class Manager extends  Employee{

	public  int teamSize;
	
	
	
	public Manager(int id ,String name ,int teamSize) {
		super(id , name);
		this.teamSize=teamSize;
		
		
	}
	
	public void managermethod() {
		System.out.println("Name :"+name+"  id :"+id+"   teamSize :   "+teamSize);
	}
	

}
