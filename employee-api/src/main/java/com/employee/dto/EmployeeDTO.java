package com.employee.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import com.employee.constants.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Employee DTO")
public class EmployeeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Employee's id", name = "Id", example = "1")
	private Long Id;

	@ApiModelProperty(value = "First name of the employee", name = "firstName", required = true, example = "James")
	@NotNull(message = "Employee's first name cannot be null")
	@NotBlank(message = "Employee's first name is required")
	@Size(min = 2, message = "Employee's first name should have at least 2 characters")
	@Size(max = 20, message = "Employee's first name should not be greater than 20 characters")
	private String firstName;

	@ApiModelProperty(value = "Last name of the employee", name = "lastName", required = true, example = "Bond")
	@NotNull(message = "Employee's last name cannot be null")
	@NotBlank(message = "Employee's last name is required")
	@Size(min = 2, message = "Employee's last name should have at least 2 characters")
	@Size(max = 20, message = "Employee's last name should not be greater than 20 characters")
	private String lastName;

	@ApiModelProperty(value = "Email id of the employee", name = "email", required = true, example = "james@gmail.com")
	@NotNull(message = "Employee's email cannot be null")
	@NotBlank(message = "Employee's email is required")
	@Email(message = "Employee's email should be a valid email format")
	private String email;

	@ApiModelProperty(value = "Employee's date of birth in YYYY-MM-DD format", name = "dob", required = true, example = "2000-01-25")
	@NotNull(message = "Employee's date of birth cannot be null")
	@Past(message = "Emlpoyee's date of birth cannot be in the present or in the future")
	private LocalDate dob;
	
	@ApiModelProperty(value = "Emloyee's gender", name = "gender", required = true, example = "[MALE, FEMALE]")
	@NotNull(message = "Employee's gender cannot be null")
	private Gender gender;
	
	@ApiModelProperty(value = "Emloyee's department id", name = "departmentId", required = true, example = "61b79491db53d36a9c593edf")
	@NotNull(message = "Employee's department id cannot be null")
	@NotBlank(message = "Employee's department id is required")
	private String departmentId;

	@ApiModelProperty(value = "System calculated age of the employee based on the employee DOB, never stored in the database", name = "age")
	private Integer age;
	
	
	

}
