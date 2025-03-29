package demo.sample.emp;

public class Employee {
	public  int id;
	public String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public void employee() {
		System.out.println("EmployeeId :"+id+"name :"+name);
		
	}
}
