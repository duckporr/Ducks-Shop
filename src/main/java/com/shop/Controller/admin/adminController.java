package com.shop.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {
 @GetMapping
 public String index() {
	 return"redirect:/admin/";
 }
 @RequestMapping("/")
 public String Home() {
	 return "/admin/category/Home";
 }
}
