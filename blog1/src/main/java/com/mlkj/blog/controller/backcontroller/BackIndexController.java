package com.mlkj.blog.controller.backcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back/")
public class BackIndexController {
	@RequestMapping("login")
	public String login() {
			return "back/login";
	}
	/*@RequestMapping("index")
	public String main() {
		return "back/main";
	}*/
	
	@RequestMapping("index")
	public String index() {
		return "back/index";
	}

}
