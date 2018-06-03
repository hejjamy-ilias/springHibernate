package com.journaldev.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.dao.PersonDAO;
import com.journaldev.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		PersonDAO personDAO = ctx.getBean(PersonDAO.class);
		
		System.out.println("test ok");
		
		Person person = new Person();
		person.setName("Pankaj");
		person.setCountry("India");
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		
		ctx.close();
	}

}
