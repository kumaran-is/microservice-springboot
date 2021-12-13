package com.department.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ValidationError extends SubError {
	private String object;
	private String field;
    private Object rejectedValue;
    private String message;
}
