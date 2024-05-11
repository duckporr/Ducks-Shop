package com.shop.Controller.Frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	@RequestMapping("/blog")
	public String index() {
		return "User/Blog";
	}

}
