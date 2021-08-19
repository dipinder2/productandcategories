package com.dipinder.productcategories1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dipinder.productcategories1.models.Category;
import com.dipinder.productcategories1.models.Product;
import com.dipinder.productcategories1.repos.ProductRepository;



@Service
public class ProductService {
	// adding the product repository as a dependency
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	// returns all the products
	public List<Product> allProducts() {
		
		return productRepository.findAll();
	}
	// creates a product
	public Product createProduct(Product b) {
		return productRepository.save(b);
	}
	// retrieves a product
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	public Product updateProduct(Product b) {
		return productRepository.save(b);
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	public List<Product> findAllByCategories(Category category){
		
		return productRepository.findAllByCategories(category);
	}
	public List<Product> findMissingProducts(Category category){
		return productRepository.findByCategoriesNotContaining(category);
	}

}