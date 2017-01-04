package com.rxwx.admin.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.admin.mapper.RoleMapper;
import com.rxwx.common.exception.CustomException;
import com.rxwx.core.dao.AbstractService;
import com.rxwx.model.Role;
import com.rxwx.service.admin.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl  extends AbstractService  implements RoleService {
	
	@Autowired RoleMapper roleMapper;

	@Override
	public boolean addRole(Role role) throws CustomException {
		return roleMapper.addRole(role);
	}

	@Override
	public boolean updateRole(Role role) throws CustomException {
		return roleMapper.updateRole(role);
	}

	@Override
	public boolean isEnableRole(Role role) throws CustomException {
		return roleMapper.isEnableRole(role);
	}


	@Override
	public boolean roleAddResource(Integer roleId, Integer[] resourceId) throws CustomException {
		boolean bool = roleMapper.roleDelAllResourceById(roleId);
		if(bool){
			return roleMapper.roleAddResource(roleId,resourceId);
		}
		return false;
	}

	@Override
	public boolean roleDelAllResourceById(Integer roleId) throws CustomException {
		return roleMapper.roleDelAllResourceById(roleId);
	}

	

}
