package com.example.associations;

import com.example.associations.Repository.CustomerRepository;
import com.example.associations.entities.Customer;
import com.example.associations.entities.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class AssociationsApplicationTests {
	@Autowired
	CustomerRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer()
	{
		Customer customer=new Customer();
		customer.setName("john");
		HashSet <PhoneNumber> numbers=new HashSet<PhoneNumber>();
		PhoneNumber ph1= new PhoneNumber();
		ph1.setNumber("1234");
		ph1.setType("cell");
		numbers.add(ph1);

		PhoneNumber ph2= new PhoneNumber();
		ph2.setNumber("12345");
		ph2.setType("cellphone");
		numbers.add(ph2);
		repository.save(customer);

	}

}
