package com.shop.Controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LogonController {
	@RequestMapping("/logon")
	public String Logon() {
		return "admin/category/Logon";
	}
}
