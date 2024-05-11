package com.shop.Controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.Models.Category;
import com.shop.Models.Product;
import com.shop.services.CategoryService;
import com.shop.services.ProductService;
import com.shop.services.StorageService;

@Controller
@RequestMapping("/admin")
public class productController {
	@Autowired
	private StorageService storageService;
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService  categoryService;
	@RequestMapping("/product")
	public String index(Model model) {
		List<Product> listCate=this.productService.getAll();
		model.addAttribute("listCate",listCate);
		return "admin/product/index";
	}
	@GetMapping("/product-add")
	public String add(Model model ) {
		Product product = new Product();
		model.addAttribute("product",product);
		List<Category> listCate= this.categoryService.getAll();
		model.addAttribute("listCate",listCate);
		
		return "admin/product/add";
	}
	@PostMapping ("/product-add")
	
	public String Save( @ModelAttribute("product") Product product ,@RequestParam("fileImage") MultipartFile file) {
		this.storageService.store(file);
		String fileName = file.getOriginalFilename();
		product.setImage(fileName);
		if(this.productService.create(product)) {
			return"redirect:/admin/product";
		}
		return"admin/product/add";
			
		}
	@GetMapping("/delete-product/{id}")
	public String delete(@PathVariable("id") Integer id) {
		if(this.productService.Delete(id)) {
			return"redirect:/admin/product";
		}else {
			return"redirect:/admin/product";
		}
	}
	@GetMapping("/edit-product/{id}")
	public String edit(Model model, @PathVariable Integer id) {
	    Product product = productService.FindByID(id);
	    model.addAttribute("product", product);
	    List<Category> listCate = categoryService.getAll();
		model.addAttribute("listCate", listCate); 
	    return "admin/product/edit";
	}

	@PostMapping("/edit-product")
	public String update( @ModelAttribute("product") Product product ,@RequestParam("fileImage") MultipartFile file,RedirectAttributes redirectAttrs) {
		this.storageService.store(file);
		String fileName = file.getOriginalFilename();
		product.setImage(fileName);
		if(this.productService.Update(product)) {
			redirectAttrs.addFlashAttribute("success", "Cập nhậtthành công");
			return"redirect:/admin/product";
		}
		return"admin/product/edit";
			
		}

}
