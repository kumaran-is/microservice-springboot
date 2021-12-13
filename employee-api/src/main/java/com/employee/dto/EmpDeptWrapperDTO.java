package com.employee.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Wrapper DTO for Employee DTO and Department DTO")
public class EmpDeptWrapperDTO implements Serializable {


	@ApiModelProperty(name = "employeeDTO", example = "Employee Details")
	private EmployeeDTO employeeDTO;
	
	@ApiModelProperty(name = "departmentDTO", example = "Department Details")
	private DepartmentDTO departmentDTO;
}
