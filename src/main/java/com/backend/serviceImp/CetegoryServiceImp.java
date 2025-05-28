package com.backend.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.backend.entity.Category;
import com.backend.repository.CategoryRepository;
import com.backend.service.CategoryService;



@Service
public class CetegoryServiceImp  implements CategoryService{
	
	@Autowired
	CategoryRepository cr;

	@Override
	public Boolean saveCategory(Category category) {
	
		Category save = cr.save(category);
		
		if(ObjectUtils.isEmpty(save))
		{
			return false;
		}
		return true;
		
	}

	@Override
	public List<Category> getAllCetegory() {
		
		List<Category> all = cr.findAll();
		
		return all;
	}

	
	
}
