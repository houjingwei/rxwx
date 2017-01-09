package com.rxwx.admin.shiro;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisSessionDAO extends AbstractSessionDAO {

	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);
	/**
	 * shiro-redis的session对象前缀
	 */
	private RedisManager redisManager;
	
	/**
	 * The Redis key prefix for the sessions 
	 */
	private String keyPrefix = "shiro_redis_session:";
	
	@Override
	public void update(Session session) throws UnknownSessionException {
		this.saveSession(session);
	}
	
	/**
	 * save session
	 * @param session
	 * @throws UnknownSessionException
	 */
	private void saveSession(Session session) throws UnknownSessionException{
		if(session == null || session.getId() == null){
			logger.error("session or session id is null");
			return;
		}
		
		String key = getByteKey(session.getId());
		session.setTimeout(redisManager.getExpire()*1000);		
		this.redisManager.set(key, session, redisManager.getExpire());
	}

	@Override
	public void delete(Session session) {
		if(session == null || session.getId() == null){
			logger.error("session or session id is null");
			return;
		}
		String key = getByteKey(session.getId());
		redisManager.del(key);

	}

	@Override
	public Collection<Session> getActiveSessions() {
		Set<Session> sessions = new HashSet<Session>();
		Set<String> keys = redisManager.allprefixKeys(this.keyPrefix);
		if(keys != null && keys.size()>0){
			for(String key:keys){
				System.out.println("hahahah"+key);
				Session s = redisManager.getCacheSession(key);
				sessions.add(s);
			}
		}
		
		return sessions;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);  
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		try {
			if(sessionId == null){
				logger.error("session id is null");
				return null;
			}
			Session s = redisManager.getCacheSession(getByteKey(sessionId));
			return s;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	/**
	 * 获得byte[]型的key
	 * @param key
	 * @return
	 */
	private String getByteKey(Serializable sessionId){
		String preKey = this.keyPrefix + sessionId;
		return preKey;
	}

	public RedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	/**
	 * Returns the Redis session keys
	 * prefix.
	 * @return The prefix
	 */
	public String getKeyPrefix() {
		return keyPrefix;
	}

	/**
	 * Sets the Redis sessions key 
	 * prefix.
	 * @param keyPrefix The prefix
	 */
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}
	
	
}
