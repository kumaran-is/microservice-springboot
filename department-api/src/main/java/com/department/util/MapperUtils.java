package com.department.util;

import org.springframework.beans.BeanUtils;
import com.department.dto.DepartmentDTO;
import com.department.entity.Department;

public class MapperUtils {

    public static DepartmentDTO entityToDTO(Department department) {
    	DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department, departmentDTO);
        return departmentDTO;
    }

    public static Department dtoToEntity(DepartmentDTO departmentDTO) {
    	Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        return department;
    }
}