package demo.sample.emp;

public class Devoleper extends Employee {
	
	String programinLnguage;
	
	public Devoleper(int id ,String name,String programinLnguage) {
		super(id,name);
		this.programinLnguage=programinLnguage;
		
	}
	
	public void devolpeInfo() {
   System.out.println("id :"+id+"  :name :"+name+"  :programing :"+programinLnguage);
   
	}

}
