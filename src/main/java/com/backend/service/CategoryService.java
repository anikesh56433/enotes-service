package com.backend.service;

import java.util.List;

import com.backend.dto.CategoryDto;
import com.backend.dto.CategoryResponse;
import com.backend.entity.Category;

public interface CategoryService {
	
public Boolean saveCategory(CategoryDto categoryDto);

public List<Category> getAllCetegory();



public List<CategoryResponse> getResponse();





}
