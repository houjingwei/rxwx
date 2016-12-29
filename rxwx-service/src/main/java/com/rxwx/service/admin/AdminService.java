package com.rxwx.service.admin;

import java.util.List;
import java.util.Set;

import com.rxwx.common.exception.CustomException;
import com.rxwx.model.Admin;
import com.rxwx.vo.AdminResourceVo;

public interface AdminService {
	
	/**
	 * 账户集合
	 * @return
	 */
	List<Admin> findList() throws CustomException;


	/**
	 * 获取账户角色集合
	 * @param username
	 * @return
	 */
    Set<String> findRoles(String account) throws CustomException;


	/**
	 * 获取账户权限集合
	 * @param username
	 * @return
	 */
	Set<String> findResources(String account) throws CustomException;

	/**
	 * 通过账户名获取账户
	 * @param username
	 * @return
	 */
	Admin findByAccount(String account) throws CustomException;
	
	
	/**
	 * 用户拥有的类行为URL的资源
	 * @param adminId
	 * @return
	 * @throws CustomException
	 */
	List<AdminResourceVo> findAdminResourceVo(Integer adminId) throws CustomException;
	

}
