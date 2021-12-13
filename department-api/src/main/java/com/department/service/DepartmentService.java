package com.department.service;

import java.math.BigInteger;
import java.util.List;
import com.department.entity.Department;

public interface DepartmentService {
	
	public List<Department> getAllDepartments();

	public Department findDepartmentByName(String name);

	public Department saveDepartment(Department department);

	public void deleteDepartment(String name);

	public Department updateDepartment(BigInteger id, String name, String address, String code);


}
