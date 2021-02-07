package com.example.demo2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo2.entity.Employee;
import com.example.demo2.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	EmployeeService(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}

	public List<Employee> getEmployeeList() {

		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee getEmployeebyId(Long id) {

		return employeeRepository.findById(id).get();
	}

	public Employee addEmployee(Employee employee) throws Exception {
		if (employee == null) {
			throw new Exception("user is empty.....");
		}
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) throws Exception {
		if (employee == null) {
			throw new Exception("user is empty.....");
		}
		return addEmployee(employee);
	}
	
	public void deleteUser(Employee employee){
		employeeRepository.delete(employee);
	}

}
