package com.mlkj.blog.controller.backcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlkj.blog.bean.UserInfo;
import com.mlkj.blog.service.UserInfoService;
import com.mlkj.blog.utils.PageBean;

@Controller
@RequestMapping("/back/user/")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("list")
	public String list(UserInfo user,Integer page,Model model) {
		 PageBean<UserInfo> pageBean = userInfoService.getUserList(user,page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("userInfo", user);
		return "back/userinfo/userinfo_list";
	}
	
	
	
	

}
