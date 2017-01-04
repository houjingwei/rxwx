package com.rxwx.admin.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.rxwx.model.Admin;
import com.rxwx.vo.AdminResourceVo;

public interface AdminMapper {

	public List<Admin> findList();

	public Set<String> findRoles(String account);

	public Set<String> findResources(String account);

	public Admin findByAccount(String account);

	public List<AdminResourceVo> findAdminResourceVo(Integer adminId);

	public boolean addAdmin(Admin admin);

	public boolean updateAdmin(Admin admin);

	public boolean isEnableAdmin(Admin admin);
	
	public boolean adminAddRole(@Param("adminId") Integer adminId, @Param("roleIds") Integer[] roleId);

	public boolean adminDelAllRoleById(@Param("adminId") Integer adminId);

}
