package com.cjzheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cjzheng.pojo.User;
import com.cjzheng.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource
	public UserService userService;

	@RequestMapping(value = "/get")
	public String getUserById(Model model, HttpServletRequest request) {
		User user = new User();
		user.setId("1");
		user = userService.get(user);
		System.out.println(user + "----------------------------------------" + user.getName());
		model.addAttribute("cc", user);
		request.getSession().setAttribute("u", user);
		return "main";
	}
}
