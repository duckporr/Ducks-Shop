package com.shop.Controller.Frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AboutController {
	@RequestMapping("/about")
	public String Home() {
		return "User/About";
	}
	

}
