package com.employee.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmpDeptWrapperDTO;
import com.employee.dto.EmployeeDTO;
import com.employee.exception.InvalidInputException;
import com.employee.mapper.EmployeeMapper;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.util.CommonUtils;

@Slf4j
@RestController
@RequestMapping("/api/v1/employees")
@RefreshScope
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Value("${com.employee.microservice.prop}")
	private String prop;
	
	@GetMapping("/prop")
	@ApiOperation("Returns custom configuration value from cloud config server to test dynamic refresh of configuration values ")
	public String getProp() {
		return this.prop;
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Returns an employee by id")
	public ResponseEntity<EmployeeDTO> findEmployeeById(@Valid @PathVariable("id") Long id) {
		if (null == id || id.equals(0L)) {
			throw new InvalidInputException("702", "Id is not valid");
		}
		// return 200, with JSON body
		return ResponseEntity.ok().body(EmployeeMapper.entityToDTO(employeeService.findEmployeeById(id)));
	}
	
	@GetMapping("/email/{email}")
	@ApiOperation("Returns an employee by email")
	public ResponseEntity<EmployeeDTO> findEmployeeByEmail(@Valid @PathVariable("email") String email) {
		if (CommonUtils.isBlankString(email)) {
			throw new InvalidInputException("703", "Email is null or blank");
		}
		// return 200, with JSON body
		return ResponseEntity.ok().body(EmployeeMapper.entityToDTO(employeeService.findEmployeeByEmail(email)));
	}
	
	@GetMapping("/dept/{id}")
	@ApiOperation("Returns an employee with department details")
	public ResponseEntity<EmpDeptWrapperDTO> findEmployeeWithDepartment(@Valid @PathVariable("id") Long id) {
		if (null == id || id.equals(0L)) {
			throw new InvalidInputException("702", "Id is not valid");
		}
		// return 200, with JSON body
		return ResponseEntity.ok().body(employeeService.findEmployeeWithDepartment(id));
	}
	
	@GetMapping
	@ApiOperation("Returns all the Employee")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		// return 200, with JSON body
		return ResponseEntity.ok()
				.body(
					 employeeService.getAllEmployees()
					.stream()
					.map(EmployeeMapper::entityToDTO)
				    .collect(Collectors.toList())
				);
	}
	
	@PostMapping
	@ApiOperation("Add a new Employee")
	public ResponseEntity<EmployeeDTO> addNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {

		log.info("employeeDTO >>>> ", employeeDTO);
		Employee savedEmployee = employeeService.saveEmployee(EmployeeMapper.dtoToEntity(employeeDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeMapper.entityToDTO(savedEmployee));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Delete an Employee")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id) {
		if (null == id || id.equals(0L)) {
			throw new InvalidInputException("702", "Id is not valid");
		}
		employeeService.deleteEmployee(id);
		// The request has been accepted for processing, but the processing has not been
		// completed
		// return ResponseEntity.accepted().build();
		// no content to return
		return ResponseEntity.noContent().build();
	}


	@PutMapping("/{id}")
	@ApiOperation("Update an Employee")
	public ResponseEntity<EmployeeDTO> modifyDepartment(@PathVariable("id") Long id,
			@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "email", required = false) String email) {
		if (null == id || id.equals(0L)) {
			throw new InvalidInputException("702", "Id is not valid");
		}
		return ResponseEntity.ok()
				.body(EmployeeMapper.entityToDTO(employeeService.updateEmployee(id, firstName, lastName, email)));

	}
	

}
