package com.backend.serviceImp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.backend.dto.CategoryDto;
import com.backend.dto.CategoryResponse;
import com.backend.entity.Category;
import com.backend.repository.CategoryRepository;
import com.backend.service.CategoryService;



@Service
public class CetegoryServiceImp  implements CategoryService{
	
	private static final Object CategoryResponse = null;


	@Autowired
    private CategoryRepository cr;
	
	
	@Autowired
	private ModelMapper mapper;
	

	

	
	

	
	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {
		
		Category category = mapper.map(categoryDto, Category.class);
	
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

	@Override
	public List<CategoryResponse> getResponse() {
		
		List<Category> categorys = cr.findByIsActiveTrue();
		
		List<com.backend.dto.CategoryResponse> list = categorys.stream().map(cat->mapper.map(cat,CategoryResponse.class)).toList();
		
		return list;
	}

	@Override
	public Optional<Category> getById(Integer id) {
		
		Optional<Category> byId = cr.findById(id);
		
		
		return byId;
	}

	@Override
	public Boolean deleteByIdData(Integer id) {
		
		   Optional<Category> byId = cr.findById(id);
		   cr.deleteById(id);
		   if(byId.isPresent())
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
		 
		
		
	}

	
	
}
