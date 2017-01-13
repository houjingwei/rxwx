package com.rxwx.admin.shiro;


import java.util.Set;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.rxwx.common.exception.CustomException;
import com.rxwx.service.cache.CacheService;

public class RedisManager {
	
	@Autowired CacheService cacheService;
	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}
	private int expire = 30;
	public int getExpire() {
		return expire;
	}
	public void setExpire(int expire) {
		this.expire = expire;
	}

	public void set(String key, Session session, int expire) {
		try {
			System.out.println("********123*******");
			System.out.println(key+"********123*******"+session);
			cacheService.add(key, session);
			cacheService.expire(key, expire);
		} catch (CustomException e) {
			System.out.println("********1--23*******");
			e.printStackTrace();
		}
		
	}
	
	public void set(String key, Object value) {
		System.out.println("********456*******");
		try {
			cacheService.add(key, value);
		} catch (CustomException e) {
			System.out.println("********4--56*******");
			e.printStackTrace();
		}
	}
	
	public void del(String key) {
		cacheService.remove(key);
	}

	public Set<String> allprefixKeys(String prefix) {
		Set<String> keySet = cacheService.allprefixKeys(prefix);
		return keySet;
	}
	public Session getCacheSession(String key) {
		try {
			System.out.println(key+"********getCacheSession*******");
			System.out.println(key+"********getCacheSession*******"+cacheService.get(key));
			Object obj = getObjByKey(key);
			if(null!=obj){
				return (Session) obj;
			}
			return null;
		} catch (CustomException e) {
		}
		return null;
	}
	
	public Object getObjByKey(String key) {
		System.out.println(key+"********getObjByKey*******");
		return cacheService.get(key);
	}
	public String dbSize() {
		return cacheService.dbSize();
	}
	public void flushDB() {
		cacheService.flushDB();
	}
	
	
	
	
	
	
	
}
