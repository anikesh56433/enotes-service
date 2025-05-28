package com.backend.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel {

	private Boolean isActive;

	private Boolean isDeleted;

	private Integer createdBy;

	@Column(name = "created_on", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdOn;

	private Integer updatedBy;

	private Date updatedOn;

}
