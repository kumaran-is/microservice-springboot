package com.department.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.department.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Long>{

	@Transactional(readOnly = true)
	// @Query("SELECT s FROM Department s where s.name = ?1")
	Optional<Department> findDepartmentByName(String name);
	
	
	Optional<Department> deleteByName(String name);

}
