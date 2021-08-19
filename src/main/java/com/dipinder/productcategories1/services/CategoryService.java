package com.dipinder.productcategories1.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dipinder.productcategories1.models.Category;
import com.dipinder.productcategories1.models.Product;
import com.dipinder.productcategories1.repos.CategoryRepository;



@Service
public class CategoryService {
	// adding the category repository as a dependency
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	// returns all the categorys
	public List<Category> allCategorys() {
		
		return categoryRepository.findAll();
	}
	// creates a category
	public Category createCategory(Category b) {
		return categoryRepository.save(b);
	}
	// retrieves a category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	public Category updateCategory(Category b) {
		return categoryRepository.save(b);
	}
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
	List<Category> findAllByProducts(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	List<Category> findByProductsNotContaining(Product product){		
		return 	categoryRepository.findByProductsNotContaining(product);
	}

}