package com.rxwx.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.rxwx.common.mybatis.page.Page;

public class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	final static public String MSG_SUCCESS = "success";

	final static public String MAP_CODE = "code";

	final static public String MAP_MSG = "msg";

	final static public String MAP_DATA = "data";
	
	final static public int CODE_SUCCESS = 0;

	public static final int CODE_ERROR_EXCEPTION = -99;

	public static final String MSG_ERROR_EXCEPTION = "系统未知异常";
	
	public final static int DEFAULT_PAGESIZE = 20;


	/**
	 * 处理返回结果
	 * 
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	final protected Map<String, Object> getResultMap(int code, String msg, Object data) {
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put(MAP_CODE, code);
		map.put(MAP_MSG, msg);
		map.put(MAP_DATA, data);
		logger.info("return map : " + map);
		return map;
	}

	final protected String getResultMapJsonp(int code, String msg, Object data, Map<String, String> requestMap) {
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put(MAP_CODE, code);
		map.put(MAP_MSG, msg);
		map.put(MAP_DATA, data);
		String resultJson = "";
		try {
			resultJson = JSON.toJSONString(map);
		} catch (Exception e) {

		}
		
		String callback = requestMap.get("callback");
		if (StringUtils.isEmpty(callback)) {
			logger.info("return map : " + map);
			return resultJson;
		} else {
			String result = callback + "(" + resultJson + ")";
			logger.info("result : " + result);
			return result;
		}

	}
	
	
	/**
	 * 获取页面提交的分页信息
	 *
	 * @param requestMap
	 * 
	 * @return
	 */
	final protected Page getRequestPageVO_default(Map<String, String> requestMap)
	{
		Page page = null;
		String p = requestMap.get("page");
		String ps = requestMap.get("pageSize");
		try
		{
			if (!StringUtils.isEmpty(p) && !StringUtils.isEmpty(ps))
			{
				page = new Page(new Integer(p), new Integer(ps));
			} else if (!StringUtils.isEmpty(p)) {
				page = new Page(new Integer(p), DEFAULT_PAGESIZE);
			} else
			{
				page = new Page(1, DEFAULT_PAGESIZE);
			}

		} catch (NumberFormatException e)
		{

		}
		return page;
	}
}
