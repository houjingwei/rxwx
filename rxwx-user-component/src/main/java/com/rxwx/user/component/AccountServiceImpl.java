package com.rxwx.user.component;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.common.constants.CacheConstants;
import com.rxwx.common.exception.CustomException;
import com.rxwx.common.exception.CustomExceptionEnum;
import com.rxwx.common.utils.UUIDGenerator;
import com.rxwx.core.dao.AbstractService;
import com.rxwx.model.User;
import com.rxwx.service.cache.CacheService;
import com.rxwx.service.user.AccountService;
import com.rxwx.user.mapper.UserMapper;
import com.rxwx.vo.UserVo;

@Service(value = "accountService")
public class AccountServiceImpl extends AbstractService implements AccountService {

	@Autowired
	private CacheService cacheService;
	@Autowired
	UserMapper userMapper;

	/**
	 * 登录
	 */
	public UserVo login(String phone, String password, String ip) throws CustomException {
		UserVo userVo = null;
		if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
			throw new CustomException(CustomExceptionEnum.COMMON_WRONG_PARAMS);
		}
		//通过手机查询用户
		User user = selectUserByPhone(phone, User.STATUS_ACTIVATE);
		if (user == null) {
			logger.warn("user is null. phone = " + phone);
			throw new CustomException(CustomExceptionEnum.USER_NOT_EXIST);
		} else {
			String pws = StringUtils.isNoneBlank(user.getPassword()) ? user.getPassword() : "";
			if (pws.equals(password)) {
				if (User.STATUS_ACTIVATE == user.getStatus()) {
					// 如果密码匹配则查询用户信息
					if (!User.STATUS_ACTIVATE.equals(user.getStatus())) {
						logger.error("userInfo status error. userId = " + user.getId());
						throw new CustomException(CustomExceptionEnum.USER_STAUTS_ERROR);
					}
					// 转化vo对象
					userVo = getUserDetail(user);
					userVo.setToken(getLoginToken(user.getId()));
				} else {
					logger.warn("user status error. userId = " + user.getId());
					throw new CustomException(CustomExceptionEnum.LOGIN_USER_STAUTS_ERROR);
				}
			} else {
				logger.warn("user psw error. input password = " + password);
				throw new CustomException(CustomExceptionEnum.LOGIN_USER_PSW_ERROR);
			}
		}
		return userVo;
	}
	
	
	public boolean loginOut(Long uid, String token, String ip) throws CustomException {
		boolean bool = false;
		if (null==uid || StringUtils.isEmpty(token)) {
			throw new CustomException(CustomExceptionEnum.COMMON_WRONG_PARAMS);
		}
		
		Object oldToken = this.cacheService.get(CacheConstants.getUserLogin("token_userId_" + uid));
		if(oldToken.equals(token)){
			this.cacheService.remove(CacheConstants.getUserLogin("token_" + oldToken));
			this.cacheService.remove(CacheConstants.getUserLogin("token_userId_" + uid));
			bool = true;
		}
		
		return bool;
	}
	
	
	
	

	private String getLoginToken(Long userId) {
		final String token = UUIDGenerator.getToken();
		// 清除之前用户id的 token
		Object oldToken = this.cacheService.get(CacheConstants.getUserLogin("token_userId_" + userId));
		if (null != oldToken)
			this.cacheService.remove(CacheConstants.getUserLogin("token_" + oldToken));
		// 保存token到redis
		this.cacheService.add(CacheConstants.getUserLogin("token_userId_" + userId), token);
		this.cacheService.add(CacheConstants.getUserLogin("token_" + token), userId);
		return token;
	}

	private UserVo getUserDetail(User user) {
		UserVo vo = new UserVo();
		BeanUtils.copyProperties(user, vo);
		return vo;
	}

	public User selectUserByPhone(String phone, Integer status) throws CustomException {
		User record = null;
		try {
			User user = new User();
			user.setPhone(phone);
			user.setStatus(status);
			List<User> list = selectUserList(user);
			if (null != list && list.size() > 0) {
				record = list.get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(CustomExceptionEnum.COMMON_DB_ERRORS);
		}
		return record;
	}

	public List<User> selectUserList(User user) throws CustomException {
		List<User> list = null;
		try {
			list = userMapper.selectUserList(user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(CustomExceptionEnum.COMMON_DB_ERRORS);
		}

		return list;
	}

	public boolean verifToken(String token, Long userId, String ip) throws CustomException {
		if (StringUtils.isEmpty(token) || null == userId || userId <= 0) {
			throw new CustomException(CustomExceptionEnum.COMMON_WRONG_PARAMS);
		}
		boolean result = false;
		System.out.println("*********uid*********"+cacheService.get(CacheConstants.getUserLogin("token_" + token)));
		Long sessionUserId = (Long) cacheService.get(CacheConstants.getUserLogin("token_" + token));
		if (null != userId) {
			if (userId.equals(sessionUserId))
				result = true;
		}
		return result;
	}

	

}
