package com.example.demo2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.demo2.entity.Employee;
import com.example.demo2.repository.EmployeeRepository;

@SpringBootApplication
@EnableEurekaClient
public class Demo2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2ServiceApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(EmployeeRepository employeeRepository) throws Exception {
        return (String[] args) -> {
        	Employee user1 = new Employee("John", "john@domain.com");
        	Employee user2 = new Employee("Julie", "julie@domain.com");
        	employeeRepository.save(user1);
        	employeeRepository.save(user2);
        	employeeRepository.findAll().forEach(user -> System.out.println(user));
        };
    }
}
