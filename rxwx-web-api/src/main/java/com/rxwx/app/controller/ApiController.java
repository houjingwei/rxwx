package com.rxwx.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rxwx.common.exception.CustomException;
import com.rxwx.model.User;
import com.rxwx.service.user.AccountService;
import com.rxwx.service.user.UserService;
import com.rxwx.vo.UserVo;


@Controller
@RequestMapping(value = "/user")
public class ApiController extends BaseController{

	
	@Autowired  UserService userService;
	@Autowired  AccountService accountService;
	
	@RequestMapping(value = "/userList")
    @ResponseBody	
    public Object userList(@RequestParam Map<String, String> requestMap, HttpServletRequest request,
			HttpServletResponse response){
		Object data = null;
		int code = BaseController.CODE_SUCCESS;
		String msg = BaseController.MSG_SUCCESS;

		try {
			List<User> list = userService.findUserList();
			data = list;
		} catch (CustomException ce) {
			logger.error("code:" + ce.getException().getCode() + " msg:" + ce.getException().getMsg());
			code = ce.getException().getCode();
			
		}catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			code = BaseController.CODE_ERROR_EXCEPTION;
			msg = BaseController.MSG_ERROR_EXCEPTION;
		}
		
		return this.getResultMap(code, msg, data);
    }
	
	
	@RequestMapping(value = "/login")
    @ResponseBody	
    public Object login(@RequestParam Map<String, String> requestMap, HttpServletRequest request,
			HttpServletResponse response,String phone,String password){
		Object data = null;
		int code = BaseController.CODE_SUCCESS;
		String msg = BaseController.MSG_SUCCESS;

		try {
			UserVo vo = accountService.login(phone, password, request.getRemoteHost());
			if(null!=null){
				data = vo;
			}else{
				msg = "用户名或密码错误";
			}
		} catch (CustomException ce) {
			logger.error("code:" + ce.getException().getCode() + " msg:" + ce.getException().getMsg());
			code = ce.getException().getCode();
			msg = ce.getMessage();
			
		}catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			code = BaseController.CODE_ERROR_EXCEPTION;
			msg = BaseController.MSG_ERROR_EXCEPTION;
		}
		
		return this.getResultMap(code, msg, data);
    }
	
	
	@RequestMapping(value = "/loginOut")
    @ResponseBody	
    public Object loginOut(@RequestParam Map<String, String> requestMap, HttpServletRequest request,
			HttpServletResponse response,Long uid,String token){
		Object data = null;
		int code = BaseController.CODE_SUCCESS;
		String msg = BaseController.MSG_SUCCESS;

		try {
			boolean bool = accountService.loginOut(uid, token, request.getRemoteHost());
			data = bool;
		} catch (CustomException ce) {
			logger.error("code:" + ce.getException().getCode() + " msg:" + ce.getException().getMsg());
			code = ce.getException().getCode();
			
		}catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			code = BaseController.CODE_ERROR_EXCEPTION;
			msg = BaseController.MSG_ERROR_EXCEPTION;
		}
		
		return this.getResultMap(code, msg, data);
    }
	
	
	
	@RequestMapping(value = "/fineOne")
    @ResponseBody
    public Object findOne(@RequestParam Map<String, String> requestMap, HttpServletRequest request,
			HttpServletResponse response){
		Object data = null;
		int code = BaseController.CODE_SUCCESS;
		String msg = BaseController.MSG_SUCCESS;

		try {
			User user = userService.findByUsername("hjw");
			data = user;
		} catch (CustomException ce) {
			logger.error("code:" + ce.getException().getCode() + " msg:" + ce.getException().getMsg());
			code = ce.getException().getCode();
			
		}catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			code = BaseController.CODE_ERROR_EXCEPTION;
			msg = BaseController.MSG_ERROR_EXCEPTION;
		}
		
		return this.getResultMap(code, msg, data);
    }
	
	
	
	
	
	
	
}
