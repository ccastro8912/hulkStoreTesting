package ec.hulkStore.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.hulkStore.model.Category;
import ec.hulkStore.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoriesController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("/category-list")
	public String listarCategory(Model model) {
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		return "categories/category-list";
	}

	@GetMapping("/add")
	public String addCategoryFrm(Model model) {	
		model.addAttribute("addStatus", true);
		model.addAttribute("category", new Category());
		return "categories/category";
	}


	@GetMapping("/edit") 
	public String editCategoryFrm(Model model, @RequestParam("id") Integer id){
		Category category = categoryService.findById(Long.valueOf(id));
		model.addAttribute("category", category);
		model.addAttribute("addStatus", false);	
		return "categories/category";
	}

	@PostMapping("/add") 
	public String actionAddCategory(Model model, @Valid Category category) {
		categoryService.saveCategory(category);
		return "redirect:category-list";	
	}


	@PostMapping("/update")
	public String updateCategory(Model model,  @Valid Category category) { 
		categoryService.updateCategory(category);
		return "redirect:category-list";	
	}


	@GetMapping("/remove")
	public String removeCategory(@RequestParam("id") Integer id){
		categoryService.deleteCategory(id);
		return "redirect:category-list";	
	}

}
