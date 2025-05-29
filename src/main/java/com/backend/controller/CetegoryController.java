package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.CategoryDto;
import com.backend.dto.CategoryResponse;
import com.backend.entity.Category;
import com.backend.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CetegoryController {

	@Autowired
	CategoryService cs;

	@PostMapping()
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) {

		Boolean saveCategory = cs.saveCategory(categoryDto);
		if (saveCategory) {
			return new ResponseEntity<>("Saved", HttpStatus.CREATED);
		}

		else {
			return new ResponseEntity<>(" Data save Failed", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping()
	public ResponseEntity<?> getAllCategory() {

		List<Category> allCetegory = cs.getAllCetegory();

		if (CollectionUtils.isEmpty(allCetegory)) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(allCetegory, HttpStatus.OK);
		}

	}

	@GetMapping("/active-category")
	public ResponseEntity<?> getResponse() {

		List<CategoryResponse> allCetegorys = cs.getResponse();

		if (CollectionUtils.isEmpty(allCetegorys)) {
			return ResponseEntity.noContent().build();
		}

		else {
			return new ResponseEntity<>(allCetegorys, HttpStatus.OK);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Optional<Category> byId = cs.getById(id);

		if (byId.isPresent()) {
			return new ResponseEntity<>( byId,HttpStatus.OK);


		} else {
			return ResponseEntity.noContent().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {

		Boolean deleteByIdData = cs.deleteByIdData(id);

		if (deleteByIdData) {
			return new ResponseEntity<>( "Data Deleted" ,HttpStatus.OK);
		} else {
			return ResponseEntity.noContent().build();
		}

	}

}
