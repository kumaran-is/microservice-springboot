package com.department.controller;

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
import com.department.dto.DepartmentDTO;
import com.department.entity.Department;
import com.department.exception.InvalidInputException;
import com.department.mapper.DepartmentMapper;
import com.department.service.DepartmentService;
import com.department.util.CommonUtils;

@Slf4j
@RestController
@RequestMapping("/api/v1/departments")
@RefreshScope
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Value("${com.department.microservice.prop}")
	private String prop;
	
	@GetMapping("/prop")
	@ApiOperation("Returns custom configuration value from cloud config server to test dynamic refresh of configuration values ")
	public String getProp() {
		return this.prop;
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Returns an department by id")
	public ResponseEntity<DepartmentDTO> findDepartmentById(@Valid @PathVariable("id") String id) {
		if (null == id) {
			throw new InvalidInputException("702", "Id is not valid");
		}
		// return 200, with JSON body
		return ResponseEntity.ok().body(DepartmentMapper.entityToDTO(departmentService.findDepartmentById(id)));
	}
	
	@GetMapping("/name/{name}")
	@ApiOperation("Returns a department by name")
	public ResponseEntity<DepartmentDTO> findDepartmentByName(@Valid @PathVariable("name") String name) {
		if (CommonUtils.isBlankString(name)) {
			throw new InvalidInputException("703", "Name is null or blank");
		}
		// return 200, with JSON body
		return ResponseEntity.ok().body(DepartmentMapper.entityToDTO(departmentService.findDepartmentByName(name)));
	}
	
	@GetMapping
	@ApiOperation("Returns all the Departments")
	public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
		// return 200, with JSON body
		return ResponseEntity.ok()
				.body(
					departmentService.getAllDepartments()
					.stream()
					.map(DepartmentMapper::entityToDTO)
				    .collect(Collectors.toList())
				);
	}
	
	@PostMapping
	@ApiOperation("Add a new Department")
	public ResponseEntity<DepartmentDTO> addNewDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {

		Department savedDepartment = departmentService.saveDepartment(DepartmentMapper.dtoToEntity(departmentDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body(DepartmentMapper.entityToDTO(savedDepartment));
	}
	
	@DeleteMapping("/{name}")
	@ApiOperation("Delete a Department")
	public ResponseEntity<Void> deleteDepartmentByName(@PathVariable("name") String name) {
		if (CommonUtils.isBlankString(name)) {
			throw new InvalidInputException("703", "Name is null or blank");
		}
		departmentService.deleteDepartment(name);
		// The request has been accepted for processing, but the processing has not been
		// completed
		// return ResponseEntity.accepted().build();
		// no content to return
		return ResponseEntity.noContent().build();
	}


	@PutMapping("/{id}")
	@ApiOperation("Update a Department")
	public ResponseEntity<DepartmentDTO> modifyDepartment(@PathVariable("id") String id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "address", required = false) String address,
			@RequestParam(name = "code", required = false) String code) {
		if (null == id) {
			throw new InvalidInputException("702", "Id is not valid");
		}
		return ResponseEntity.ok()
				.body(DepartmentMapper.entityToDTO(departmentService.updateDepartment(id, name, address, code)));

	}

}
