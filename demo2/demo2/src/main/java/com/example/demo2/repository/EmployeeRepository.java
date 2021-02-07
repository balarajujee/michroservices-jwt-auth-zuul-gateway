package com.example.demo2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo2.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	
}