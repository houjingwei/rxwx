package com.rxwx.admin.mapper;

import org.apache.ibatis.annotations.Param;

import com.rxwx.model.Role;

public interface RoleMapper {

	boolean addRole(Role role);

	boolean updateRole(Role role);

	boolean isEnableRole(Role role);
	
	boolean roleAddResource(@Param("roleId") Integer roleId, @Param("resourceIds") Integer[] resourceId);

	boolean roleDelAllResourceById(@Param("roleId") Integer roleId);

	

}
