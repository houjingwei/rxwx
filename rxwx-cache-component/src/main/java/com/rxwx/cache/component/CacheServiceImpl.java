package com.rxwx.cache.component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.rxwx.common.exception.CustomException;
import com.rxwx.common.exception.CustomExceptionEnum;
import com.rxwx.service.cache.CacheService;

public abstract class CacheServiceImpl implements CacheService {
	
	protected abstract String getKey(String key);
	private final static Logger logger = Logger.getLogger(CacheServiceImpl.class);

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 
	 * 批量删除对应的value
	 * 
	 * 
	 * 
	 * @param keys
	 * 
	 */
	public void remove(final String... keys) {
		redisTemplate.delete(Arrays.asList(keys));
		for (String key : keys) {
			removeObject(getKey(key));
		}
	}

	/**
	 * 
	 * 批量删除key
	 * 
	 * 
	 * 
	 * @param pattern
	 * 
	 */
	public void removePattern(final String pattern) {
		Set<String> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}

	/**
	 * 
	 * 删除对应的value
	 * 
	 * 
	 * 
	 * @param key
	 * 
	 */
	public void removeObject(final String key) {
		redisTemplate.delete(getKey(key));
	}

	/**
	 * 
	 * 判断缓存中是否有对应的value
	 * 
	 * 
	 * 
	 * @param key
	 * 
	 * @return
	 * 
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(getKey(key));
	}


	public Long increment(final String key, Long value) {
		Long result = 0L;
		try {
			Long operations = redisTemplate.opsForValue().increment(getKey(key), value);
			result = operations;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, e.getMessage());
		}
		return result;
	}

	public Long getIncrValue(String key) throws CustomException {
		Long result = 0L;
		try {
			Long operations = redisTemplate.opsForValue().increment(getKey(key), 0L);
			result = operations;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, e.getMessage());
		}
		return result;
	}

	public void add(String key, Object value, int minutes) throws CustomException {
		try {
			redisTemplate.opsForValue().set(getKey(key), value, minutes, TimeUnit.MINUTES);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public void add(String key, Object value) throws CustomException {
		try {
			redisTemplate.opsForValue().set(getKey(key), value);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}

	}

	public void addList(String key, Collection<? extends Object> values) throws CustomException {
		try {
			if (values != null && values.size() > 0) {
//				remove(key);
				// redisTemplate.opsForList().leftPushAll(key, values);
				redisTemplate.opsForList().leftPushAll(getKey(key), values);
//				for (Object value : values) {
//					redisTemplate.opsForList().leftPush(key, value);
//				}
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}

	}

	public void addList(String key, Collection<? extends Object> values, int minutes) throws CustomException {
		try {
//			remove(key);
			redisTemplate.opsForList().leftPushAll(key, values, minutes, TimeUnit.MINUTES);

//			for (Object value : values) {
//				redisTemplate.opsForList().leftPush(key, value);
//			}
//			redisTemplate.expire(key, minutes, TimeUnit.MINUTES);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public void addOneToList(String key, Object value) throws CustomException {
		try {
			redisTemplate.opsForList().leftPush(key, value);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public Object get(String key) throws CustomException {
		try {
			return redisTemplate.opsForValue().get(key);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public List<? extends Object> getList(String key) throws CustomException {
		try {
			Long size = redisTemplate.opsForList().size(key);
			return redisTemplate.opsForList().range(key, 0, size);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public Object getListFirstOne(String key) throws CustomException {
		try {
			List<Object> le = redisTemplate.opsForList().range(key, 0, 1);
			if (le != null && le.size() > 0) {
				return le.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public long getCountLike(String keyPrefix) throws CustomException {
		try {
			if (StringUtils.isNotEmpty(keyPrefix)) {
				Set<String> matchedCacheKeys = redisTemplate.keys(keyPrefix + "*");
				return matchedCacheKeys.size();
			} else {
				return 0;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public void remove(String key) throws CustomException {
		try {
			if (exists(key)) {
				redisTemplate.delete(key);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}

	}

	public void removeLike(String keyPrefix) throws CustomException {
		try {
			if (StringUtils.isNotEmpty(keyPrefix)) {
				Set<String> matchedCacheKeys = redisTemplate.keys(keyPrefix + "*");
				for (String cacheKey : matchedCacheKeys) {
					this.remove(cacheKey);
				}
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public int countItemsLike(String keyPrefix) throws CustomException {

		try {
			if (StringUtils.isNotEmpty(keyPrefix)) {
				Set<String> matchedCacheKeys = redisTemplate.keys(keyPrefix + "*");
				return matchedCacheKeys.size();
			} else {
				return 0;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, ex.getMessage());
		}
	}

	public void expire(String key, int minutes) throws CustomException {
		try {
			redisTemplate.expire(key, minutes, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CustomExceptionEnum.CACHE_ERROR, e.getMessage());
		}
	}

	

}
