package com.department.audit;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Data;


@Data
public class Auditable<U> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// updatable flag helps to avoid the override of column's value during the update operation

	@CreatedBy
	protected U createdBy;

	// updatable flag helps to avoid the override of column's value during the update operation
	@CreatedDate
	protected LocalDateTime createdDate;

	@LastModifiedBy
	protected U lastModifiedBy;

	@LastModifiedDate
	protected LocalDateTime lastModifiedDate;
}
