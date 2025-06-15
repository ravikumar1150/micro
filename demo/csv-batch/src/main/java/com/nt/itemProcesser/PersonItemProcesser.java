package com.nt.itemProcesser;

import org.springframework.batch.item.ItemProcessor;

import com.nt.person.Person;

public class PersonItemProcesser  implements ItemProcessor<Person,Person>{

	@Override
	public Person process(Person item) throws Exception {
		
		System.out.println("PersonItemProcesser.process()");
		
		String firstName = item.firstName();
		String lastName = item.lastName();
		
		Person obj = new Person(firstName, lastName);
		
		return obj;
	}
	
	
	

}
