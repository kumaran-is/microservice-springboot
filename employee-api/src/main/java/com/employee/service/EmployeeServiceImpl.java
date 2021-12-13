package com.employee.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.exception.ResourceAlreadyExistsException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeById(Long id) {

		return employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("700", "Employee with id " + id + " does not exists"));

	}

	
	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeByEmail(String email) {

		return employeeRepository.findByEmail(email).orElseThrow(
				() -> new ResourceNotFoundException("700", "Employee with email " + email + " does not exists"));

	}

	@Override
	public Employee saveEmployee(Employee employee) {
		log.debug("saveEmployee service employee ....." + employee);

		Optional<Employee> employeeOptional = employeeRepository.findByEmail(employee.getEmail());

		if (employeeOptional.isPresent()) {
			throw new ResourceAlreadyExistsException("701",
					"Employee with Email Id " + employee.getEmail() + " already taken");
		}

		return employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(Long id) {

		boolean exists = employeeRepository.existsById(id);
		if (!exists) {
			throw new ResourceNotFoundException("700", "Employee with id " + id + " does not exists");
		}

		employeeRepository.deleteById(id);

	}

	@Override
	public Employee updateEmployee(Long id, String firstName, String lastName, String email) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("700", "Employee with id " + id + " does not exists"));

		if (firstName != null && firstName.length() > 0 && !Objects.equals(employee.getFirstName(), firstName)) {
			employee.setFirstName(firstName);
		}

		if (lastName != null && lastName.length() > 0 && !Objects.equals(employee.getLastName(), lastName)) {
			employee.setLastName(lastName);
		}

		if (email != null && email.length() > 0 && !Objects.equals(employee.getEmail(), email)) {
			employee.setEmail(email);
		}
		return employeeRepository.save(employee);

	}
}
