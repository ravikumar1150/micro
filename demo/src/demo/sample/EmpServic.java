package demo.sample;

import java.util.ArrayList;
import java.util.List;

public class EmpServic {
	
	
	
	
	public  List<Employee>  saveEmp() {
		List<Employee> list = new ArrayList<>();
		
		Employee e = new Employee();
		e.setId(1);
		e.setName("Ravi");
		e.setCountry("India");
		e.setSal(300);
		
		Employee e1 = new Employee();
		e1.setId(2);
		e1.setName("nethra");
		e1.setCountry("chaina");
		e1.setSal(400);
		

		Employee e2 = new Employee();
		e2.setId(3);
		e2.setName("Aathvik");
		e2.setCountry("chaina");
		e2.setSal(500);
		
		list.add(e1);
		list.add(e2);
		list.add(e);
	
		
		return list;
	}

}
