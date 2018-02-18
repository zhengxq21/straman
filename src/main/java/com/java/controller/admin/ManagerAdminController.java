package com.java.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/manager")
public class ManagerAdminController {

	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
	
}
