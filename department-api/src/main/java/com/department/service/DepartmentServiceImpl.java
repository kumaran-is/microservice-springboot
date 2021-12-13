package com.department.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import com.department.entity.Department;
import com.department.exception.ResourceAlreadyExistsException;
import com.department.exception.ResourceNotFoundException;

@Slf4j
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Department> getAllDepartments() {

		return departmentRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Department findDepartmentByName(String name) {

		return departmentRepository.findDepartmentByName(name).orElseThrow(
				() -> new ResourceNotFoundException("700", "Department with name " + name + " does not exists"));

	}
	
	@Override
	public Department saveDepartment(Department department) {
		log.debug("saveDepartment service department ....." + department);

		Optional<Department> departmentOptional = departmentRepository.findDepartmentByName(department.getName());

		if (departmentOptional.isPresent()) {
			throw new ResourceAlreadyExistsException("701",
					"Department with name " + department.getName() + " already taken");
		}

		return departmentRepository.save(department);
		
	}
	
	@Override
	public void deleteDepartment(String name) {

		Optional<Department> departmentOptional = departmentRepository.findDepartmentByName(name);
		if (departmentOptional.isEmpty()) {
			throw new ResourceNotFoundException("700", "Department with name " + name + " does not exists");
		}

		departmentRepository.deleteByName(name);

	}
	
	@Override
	public Department updateDepartment(BigInteger id, String name, String address, String code) {
		
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("700", "Department with id " + id + " does not exists"));

		if (name != null && name.length() > 0 && !Objects.equals(department.getName(), name)) {
			department.setName(name);
		}

		if (address != null && address.length() > 0 && !Objects.equals(department.getAddress(), address)) {
			department.setAddress(address);
		}

		if (code != null && code.length() > 0 && !Objects.equals(department.getCode(), code)) {
			department.setCode(code);
		}
		return departmentRepository.save(department);

	}

}
