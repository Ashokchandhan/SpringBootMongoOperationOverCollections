package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.app.document.Employee;

@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private MongoRepository repo;
	@Override
	public void run(String... args) throws Exception {

		repo.deleteAll();

		//insert one row

		Employee e=(Employee) repo.save(new Employee(10,"A",2.3));

		System.out.println(e.getId());

		//bulk insert

		List<Employee> emps=repo.saveAll(Arrays.asList(

		    /*	repo.save(new Employee(11,"AS",3.6)),
				repo.save(new Employee(12,"OK",4.6)),
				repo.save(new Employee(13,"PK",5.6))
				)); */
				
				
				repo.insert(new Employee(11,"AA",3.6)),
				repo.insert(new Employee(12,"OK",5.6)), 
				repo.insert(new Employee(13,"AS",6.6))
				));

		for(Employee ee:emps) {System.out.println(ee.getId());}
		System.out.println("==**==");
		System.out.println("done");

	}
}