package com.jygj.admin.action.limitation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jygj.admin.pojo.User;
import com.jygj.admin.service.UserService;

@Controller
@RequestMapping("/limitation/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(Model model) {
		List<User> userList = userService.queryAll();
		model.addAttribute("userList", userList);
		return "limitation/user/index";
	}

}
