package com.employee.service;

import java.util.List;
import com.employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee findEmployeeById(Long id);
	
	public Employee findEmployeeByEmail(String email);

	public Employee saveEmployee(Employee employee);

	public void deleteEmployee(Long id);

	public Employee updateEmployee(Long id, String firstName, String lastName, String email);
}
