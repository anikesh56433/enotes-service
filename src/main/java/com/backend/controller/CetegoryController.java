package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Category;
import com.backend.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CetegoryController {
	
	@Autowired
	CategoryService cs;


	@PostMapping()
	   public ResponseEntity<?> saveCategory(@RequestBody Category category)
	   {
		
		Boolean saveCategory = cs.saveCategory(category);
		if(saveCategory)
		{
			 return new  ResponseEntity<>("Saved", HttpStatus.CREATED);
		}
		   
		else
		{
			 return new  ResponseEntity<>(" Data save Failed", HttpStatus.NOT_FOUND);
		}
    	 
	   }
	
	
	@GetMapping()
	public ResponseEntity<?> getAllCategory()
	{
	   
		List<Category> allCetegory = cs.getAllCetegory();
		
		if(CollectionUtils.isEmpty(allCetegory))
		{
			 return ResponseEntity.noContent().build();
		}
		else
		{
			 return new  ResponseEntity<>(allCetegory, HttpStatus.NOT_FOUND);
		}
		
	}
	
}
