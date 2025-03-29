package demo.sample;

public class Employee {

	private int id;
	private String name;
	private int sal;
	private String country;
	public Employee(int id, String name, int sal, String country) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.country = country;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", country=" + country + "]";
	}
	
	

}
