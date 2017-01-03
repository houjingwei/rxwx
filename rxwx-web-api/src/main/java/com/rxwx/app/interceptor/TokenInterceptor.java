package com.rxwx.app.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.rxwx.app.controller.BaseController;
import com.rxwx.common.annotation.ValidateToken;
import com.rxwx.common.exception.CustomException;
import com.rxwx.common.exception.CustomExceptionEnum;
import com.rxwx.common.utils.StringUtil;
import com.rxwx.service.user.AccountService;

public class TokenInterceptor implements HandlerInterceptor {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccountService accountService;

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView ex)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		int code = BaseController.CODE_SUCCESS;
		String msg = BaseController.MSG_SUCCESS;
		
		String token = request.getParameter("token");
		Long uid = NumberUtils.toLong(request.getParameter("uid"));
		try {
			if(StringUtil.hasNull(token) && null!=uid){
				throw new CustomException(CustomExceptionEnum.COMMON_WRONG_PARAMS);
			}else{
				boolean verifToken = accountService.verifToken(token, uid, null);
				if (!verifToken) {
					throw new CustomException(CustomExceptionEnum.COMMON_ERROR_TOKEN);
				}
			}
		} catch (CustomException ce) {
			this.logger.error("code:" + ce.getException().getCode() + " msg:" + ce.getException().getMsg());
			code = ce.getException().getCode();
			msg = ce.getException().getMsg();
		}

		if (code != BaseController.CODE_SUCCESS) {
			Object result = this.getResultMap(code, msg, null);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().append(JSON.toJSONString(result));
			return false;
		}
		
		return true;
	}



	final private Map<String, Object> getResultMap(int code, String msg, Object data) {
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put(BaseController.MAP_CODE, code);
		map.put(BaseController.MAP_MSG, msg);
		map.put(BaseController.MAP_DATA, data);
		logger.info("return map : " + map);
		return map;
	}
}
