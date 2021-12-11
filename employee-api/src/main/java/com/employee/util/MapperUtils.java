package com.employee.util;

import org.springframework.beans.BeanUtils;
import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;

public class MapperUtils {

    public static EmployeeDTO entityToDTO(Employee employee) {
    	EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    public static Employee dtoToEntity(EmployeeDTO employeeDTO) {
    	Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }
}