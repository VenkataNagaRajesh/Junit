package com.example.SpringBootJpaTesting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.SpringBootJpaTesting.entity.Employe;
import com.example.SpringBootJpaTesting.repo.EmployeRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeRepositoryTests {

	@Autowired
	private EmployeRepository employeRepository;
	
	@Test
	@Order(1)
	@Rollback(false)
	public void saveEmployeTest()
	{
		Employe employe = Employe.builder()
				.firstName("ramesh")
				.lastName("fadatare")
				.email("ramesh@gmail.com")
				.build();
		
	Employe emp2 =	employeRepository.save(employe);
		System.err.println(emp2+"1");
		assertThat(emp2.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void getEmployeTest()
	{
		Employe employe = employeRepository.findById((long) 1).get();
		System.out.println("\n\n\n here"+employe+ "2");
		assertThat(employe.getId()).isEqualTo((long)1);
		
	}
	
	
	@Test
	@Order(3)
	@Rollback(false)
	public void getListOfEmployesTest()
	{
		List<Employe> emp =employeRepository.findAll();
		System.out.println("\n\n\nlist of employes "+emp+"3");
		assertThat(emp.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(false)
	public void updateEmployeTest()
	{
		Employe employe = employeRepository.findById((long) 1).get();
		employe.setEmail("ram@gmail.com");
		Employe emps = employeRepository.save(employe);
		assertThat(emps.getEmail()).isEqualTo("ram@gmail.com");
	}
	
	
	@Test
	@Order(5)
	@Rollback(false)
	public void deleteEmployeTest()
	{
		Employe employe = employeRepository.findById((long) 1).get();
		employeRepository.delete(employe);
		
		
		Employe employe1 = null;
		Optional<Employe> optionalEmpOptional = employeRepository.findByEmail("ram@gmail.com");
		
		if(optionalEmpOptional.isPresent()) {
			employe1 = optionalEmpOptional.get();
		}
		assertThat(employe1).isNull();
	}
	
	
	
	
}
