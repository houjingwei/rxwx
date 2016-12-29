package com.rxwx.cache.component;

import org.springframework.stereotype.Service;

import com.rxwx.service.cache.CacheService;

@Service(value = "spCacheService")
public class SPCacheService extends CacheServiceImpl implements CacheService {
	
	public String getKey(String key){
		return "SP_"+key;
	}
}
