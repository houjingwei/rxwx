package com.rxwx.service.admin;

import com.rxwx.common.exception.CustomException;
import com.rxwx.model.Role;

public interface RoleService {
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 * @throws CustomException
	 */
	public boolean addRole(Role role) throws CustomException;
	
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 * @throws CustomException
	 */
	public boolean updateRole(Role role)throws CustomException;
	
	
	/**
	 * 启用，禁用角色
	 * @param role
	 * @return
	 * @throws CustomException
	 */
	public boolean isEnableRole(Role role)throws CustomException;

}
