package com.backend.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CategoryDto {
	
	
    private Integer id;
	
	private String name;
	
	private String description;
	
	private Boolean isActive;

	private Boolean isDeleted;

	private Integer createdBy;

	private Date createdOn;

	private Integer updatedBy;

	private Date updatedOn;

	
	
	

}
