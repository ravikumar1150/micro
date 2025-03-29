package demo.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		EmpServic e = new EmpServic();

		
		List<Integer> asList = Arrays.asList(22,33,4,55,6,77,88);
		
		List<Integer> collect2 = asList.stream().distinct().sorted((a,b)->b-a).collect(Collectors.toList()); 
		
		if(collect2.size()>1) {
			System.out.println("The Second LargestNumber Is :"+collect2.get(1));
		}
		
		List<Employee> saveEmp = e.saveEmp();
            
            List<Employee> list = saveEmp.stream().toList();
            System.out.println(list);
            
            List<Employee> collect = list.stream().filter(f->f.getSal()>200 && f.getCountry().equals("chaina")).collect(Collectors.toList());
		
		   Optional<Employee> orElseThrow = list.stream().sorted((a,b)->Integer.compare(b.getSal(), a.getSal())).skip(1).findFirst();
		   Optional<Employee> first = list.stream().sorted(Comparator.comparing(Employee :: getSal).reversed()).skip(2).findFirst();
            
		   
		     System.out.println(first);
            System.out.println(orElseThrow);
            
            
     
		
	}
	

}
