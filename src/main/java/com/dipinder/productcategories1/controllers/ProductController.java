package com.dipinder.productcategories1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dipinder.productcategories1.models.Category;
import com.dipinder.productcategories1.models.Product;
import com.dipinder.productcategories1.services.CategoryService;
import com.dipinder.productcategories1.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String home(Model model) {
		List<Product> products = productService.allProducts();
		List<Category> categories = categoryService.allCategorys();
		model.addAttribute("categories",categories);
		model.addAttribute("products",products);
		return "index.jsp";
	}
	
	@RequestMapping("/product")
	public String index(Model model) {
		List<Product> product = productService.allProducts();
		model.addAttribute("product", product);
		
		return "product/new.jsp";
	}
	
	@RequestMapping("/product/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "product/new.jsp";
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product/new.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/product/{id}")
	public String  productShow(Model model,
			@PathVariable("id") Long id) {
		
		Product product = (productService.findProduct(id));
		
		
		
		model.addAttribute("product",product);
		return "product/productShow.jsp";
	}
	
	
	@RequestMapping("/product/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		return "product/edit.jsp";
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			productService.updateProduct(product);
			return "redirect:/product";
		}
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/product";
	}
	
	
}