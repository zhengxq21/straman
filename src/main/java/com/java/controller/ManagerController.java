package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.entity.Manager;
import com.java.realm.MyRealm;
import com.java.util.CryptographyUtil;


@Controller
@RequestMapping(value="manager")
public class ManagerController {
	
	
	@RequestMapping("login")
	private String login(Manager manager,HttpServletRequest request,HttpServletResponse response)throws Exception{
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(manager.getUserName(),CryptographyUtil.md5(manager.getPassword(), "thesalt"));
		
		try {
			subject.login(token);
			return "redirect:/admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("manager", manager);
			request.setAttribute("errorInfo", "用户名或密码错误");
			return "redirect:/login.jsp";
		}
		
		
	}
	
}
