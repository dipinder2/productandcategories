package com.dipinder.productcategories1.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dipinder.productcategories1.models.Category;
import com.dipinder.productcategories1.models.Product;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	// this method retrieves all the categorys from the database
	List<Category> findAll();
	//User findByEmail(String email);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContaining(Product product);
	
	
}
