package com.example.demo2.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Employee;
import com.example.demo2.service.EmployeeService;

//import io.swagger.annotations.Api;

@RestController
public class UserRestcontroller {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/demo2/getuserlist")
	public List<Employee> getEmployee() {

		return employeeService.getEmployeeList();
	}

	@GetMapping(value = "demo2/getuser/{id}")
	public Employee getUserById(@PathVariable Long id) {

		return employeeService.getEmployeebyId(id);
	}

	@PostMapping(value = "/demo2/save")
	public Employee addUser(@RequestBody Employee employee) throws Exception {

		return employeeService.addEmployee(employee);
	}

	@PutMapping(value = "/demo2/update")
	public Employee updateUser(@RequestBody Employee employee) throws Exception {

		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping(value = "/demo2/delete")
	public String deleteUser(@RequestBody Employee employee) throws Exception {
		employeeService.deleteUser(employee);
		return "record deleted..!";
	}

}
