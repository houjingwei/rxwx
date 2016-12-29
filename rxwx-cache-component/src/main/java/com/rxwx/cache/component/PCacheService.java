package com.rxwx.cache.component;

import org.springframework.stereotype.Service;

import com.rxwx.service.cache.CacheService;

@Service(value = "pcCacheService")
public class PCacheService extends CacheServiceImpl implements CacheService {
	
	public String getKey(String key){
		return "PC_"+key;
	}
}
