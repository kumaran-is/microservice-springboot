package com.employee.dto;

import java.io.Serializable;
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

	@ApiModelProperty(value = "First name of the employee", name = "firstName", required = true, example = "James")
	@NotNull(message = "Emloyee's first name cannot be null")
	@NotBlank(message = "Emloyee's first name is required")
	@Size(min = 2, message = "Emloyee's first name should have at least 2 characters")
	@Size(max = 20, message = "Emloyee's first name should not be greater than 20 characters")
	private String firstName;

	@ApiModelProperty(value = "Last name of the employee", name = "lastName", required = true, example = "Bond")
	@NotNull(message = "Emloyee's last name cannot be null")
	@NotBlank(message = "Emloyee's last name is required")
	@Size(min = 2, message = "Emloyee's last name should have at least 2 characters")
	@Size(max = 20, message = "Emloyee's last name should not be greater than 20 characters")
	private String lastName;

	@ApiModelProperty(value = "Email id of the employee", name = "email", required = true, example = "james@gmail.com")
	@NotNull(message = "Emloyee's email cannot be null")
	@NotBlank(message = "Emloyee's email is required")
	@Email(message = "Emloyee's email should be a valid email format")
	private String email;

	@ApiModelProperty(value = "Emloyee's date of birth in YYYY-MM-DD format", name = "dob", required = true, example = "2000-01-25")
	@NotNull(message = "Emloyee's date of birth cannot be null")
	@Past(message = "Emloyee's date of birth cannot be in the present or in the future")
	private LocalDate dob;
	
	@ApiModelProperty(value = "Emloyee's gender", name = "gender", required = true, example = "[MALE, FEMALE]")
	@NotNull(message = "Emloyee's gender cannot be null")
	private Gender gender;

	@ApiModelProperty(value = "System calculated age of the employee based on the employee DOB, never stored in the database", name = "age")
	private Integer age;

}
