package com.department.service;

import java.util.List;
import com.department.entity.Department;

public interface DepartmentService {
	
	public List<Department> getAllDepartments();
	
	public Department findDepartmentById(String id);

	public Department findDepartmentByName(String name);

	public Department saveDepartment(Department department);

	public void deleteDepartment(String name);

	public Department updateDepartment(String id, String name, String address, String code);


}
