package com.rxwx.admin.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class AccountController {

	@RequestMapping(value = "/")
	@RequiresAuthentication
	public String index() {
		return "login";
	}
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String home(String username,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);   
        Subject currentUser = SecurityUtils.getSubject();   
        try {
        	if(!currentUser.isAuthenticated()){
        		currentUser.login(token);
        	}
		} catch (AuthenticationException e) {
			if(e instanceof UnknownAccountException){
				System.out.println("用户不存在");
			}else if(e instanceof IncorrectCredentialsException){
				System.out.println("密码不正确");
			}
		}  
        return "redirect:/home/index"; 
    }
	
	
	@RequestMapping(value = "/logout")
    public String logout(){
		if(null!=SecurityUtils.getSubject().getSession()){
			SecurityUtils.getSubject().logout();
		}else{
			System.out.println("已经退出了");
		}
		return  "redirect:/"; 
    }
}
