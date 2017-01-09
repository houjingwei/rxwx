package com.rxwx.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class AccountController {

	@RequestMapping(value = "/")
	public String index() {
		return "login";
	}
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,Model model){
		String errorClassName = (String) request.getAttribute("shiroLoginFailure");
		String authticationError = null;
		if (UnknownAccountException.class.getName().equals(errorClassName)) {
			authticationError = "用户不存在";
		} else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
			authticationError = "密码错误";
		} else if (errorClassName != null) {
			authticationError = "未知错误：" + errorClassName;
		}
		model.addAttribute("authticationError", authticationError);
		boolean bool = SecurityUtils.getSubject().isAuthenticated();
		System.out.println("用户认证结果 >>" + bool);
		return "login";
    }
	
	
	

	
	@RequestMapping(value = "/unauthorized")
    public String unauthorizedUrl(){
        return  "empty_page"; 
    }
}
