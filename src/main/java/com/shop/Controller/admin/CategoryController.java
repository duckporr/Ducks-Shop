package com.shop.Controller.admin;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.shop.Models.Category;
import com.shop.services.CategoryService;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	public CategoryService categoryService;
	
    @GetMapping("/category")
	public String index(Model model,@Param("keyword") String keyword,@RequestParam (name="pageNumber", defaultValue = "1") Integer pageNumber) {
    	Page<Category> list =this.categoryService.getAll(pageNumber);
    	
		
		 if(keyword!=null) { list=this.categoryService.SearchCategory(keyword,pageNumber);
		  model.addAttribute("keyword",keyword); }
		 
    	model.addAttribute("totalPage",list.getTotalPages());
    	model.addAttribute("currentPage",pageNumber);
    	model.addAttribute("list", list);
		return "admin/category/index";
	}
	@GetMapping("/add-category")
	public String add( Model model) {
		Category category = new Category();
		category.setCategoryStatus(true);
		model.addAttribute("category",category);
		return "admin/category/add";
	}
	@PostMapping("/add-category")
	public String save( @ModelAttribute("category") Category category) {
		if(this.categoryService.create(category)) {
			return"redirect:/admin/category";
		}else {
		return "admin/category/add";
		}
	}
	@GetMapping("/edit-category/{id}")
	public String edit(Model model ,@PathVariable("id") Integer id) {
		Category category = this.categoryService.FindByID(id);
		model.addAttribute("category",category);
		return "admin/category/edit";
		
	}
	@PostMapping("/edit-category")
	public String update( @ModelAttribute("category") Category category) {
		if(this.categoryService.Update(category)) {
			return"redirect:/admin/category";
		}else {
		return "admin/category/edit";
		}
	}
	@GetMapping("/delete-category/{id}")
	public String delete(@PathVariable("id") Integer id) {
		if(this.categoryService.Delete(id)) {
			return"redirect:/admin/category";
		}else {
			return"redirect:/admin/category";
		}
	}
	
	
	

}
