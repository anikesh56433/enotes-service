package com.backend.service;

import java.util.List;

import com.backend.entity.Category;

public interface CategoryService {
	
public Boolean saveCategory(Category category);

public List<Category> getAllCetegory();



}
