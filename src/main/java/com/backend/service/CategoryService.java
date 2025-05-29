package com.backend.service;

import java.util.List;
import java.util.Optional;

import com.backend.dto.CategoryDto;
import com.backend.dto.CategoryResponse;
import com.backend.entity.Category;

public interface CategoryService {
	
public Boolean saveCategory(CategoryDto categoryDto);

public List<Category> getAllCetegory();



public List<CategoryResponse> getResponse();

public Optional<Category> getById(Integer id);

public Boolean deleteByIdData(Integer id);





}
