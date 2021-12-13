package com.employee.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Department DTO")
public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Name of the department", name = "name", required = true, example = "Human Resource")
	@NotNull(message = "Department name cannot be null")
	@NotBlank(message = "Department name is required")
	@Size(min = 2, message = "Department name should have at least 2 characters")
	@Size(max = 20, message = "Department name should not be greater than 20 characters")
	private String name;
	
	@ApiModelProperty(value = "Address of the department", name = "address", required = true, example = "12345 Circle street, maple shade, NJ")
	@NotNull(message = "Department address cannot be null")
	@NotBlank(message = "Department address is required")
	@Size(min = 10, message = "Department address should have at least 10 characters")
	@Size(max = 100, message = "Department address should not be greater than 100 characters")
    private String address;
	
	@ApiModelProperty(value = "Code of the department", name = "code", required = true, example = "HR123")
	@NotNull(message = "Department cdoe cannot be null")
	@NotBlank(message = "Department code is required")
	@Size(min = 2, message = "Department code should have at least 2 characters")
	@Size(max = 6, message = "Department code should not be greater than 6 characters")
    private String code;
	
	@ApiModelProperty(value = "Id of the department", name = "id", required = true, example = "61b6c38699564a56605b7012")
	private String id;
}
