package com.dipinder.productcategories1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dipinder.productcategories1.models.Category;
import com.dipinder.productcategories1.models.Product;
import com.dipinder.productcategories1.services.CategoryService;
import com.dipinder.productcategories1.services.ProductService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;

	
	@RequestMapping("/category")
	public String index(Model model) {
		List<Category> category = categoryService.allCategorys();
		model.addAttribute("category", category);
		
		return "category/index.jsp";
	}
	
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category/new.jsp";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "category/new.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/category/{id}")
	public String  productShow(Model model,
			@PathVariable("id") Long id) {
		
		Category category = (categoryService.findCategory(id));
		model.addAttribute("category",category);
		List<Product> products = productService.findMissingProducts(category);
		model.addAttribute("products",products);
		return "category/show.jsp";
	}
	
	
	@RequestMapping("/category/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		return "category/edit.jsp";
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			categoryService.updateCategory(category);
			return "redirect:/category";
		}
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/category";
	}
	
	
	@PostMapping("/addRelation/{id}")
	public String addRelation(@PathVariable("id") Long id,
			@RequestParam("pId")Long pId) {
		Product product = productService.findProduct(pId);
		Category category = categoryService.findCategory(id);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		return "redirect:/";
	}
}