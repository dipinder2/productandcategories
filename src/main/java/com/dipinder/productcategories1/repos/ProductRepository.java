package com.dipinder.productcategories1.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dipinder.productcategories1.models.Category;
import com.dipinder.productcategories1.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	// this method retrieves all the categorys from the database
	List<Product> findAll();
	//User findByEmail(String email);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContaining(Category category);
}
