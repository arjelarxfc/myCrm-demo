package com.myproject.ssm.crm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.ssm.crm.service.UserService;
import com.myproject.ssm.model.UserModel;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("user/userId")
	public String queryUserById(HttpServletRequest request, Model model) {
		String sid=request.getParameter("userId");
		UserModel userModel = userService.queryById(Integer.parseInt(sid));
		
		model.addAttribute("user", userModel);
		
		return "pages/result";
	}
	
	@RequestMapping("user/allUsers")
	public String queryAllUsers(HttpServletRequest request, Model model){
		List<UserModel> userModels=userService.querAllUsers();
		model.addAttribute("users", userModels);
		
		return "pages/result";
	}
	
	@RequestMapping("webPage/vcore/wedding")
	public String wedding(){
		return "pages/firstPage";
	}
	
}
