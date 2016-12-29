package com.rxwx.admin.component;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.admin.mapper.AdminMapper;
import com.rxwx.core.dao.AbstractService;
import com.rxwx.model.Admin;
import com.rxwx.service.admin.AdminService;
import com.rxwx.vo.AdminResourceVo;
@Service(value = "adminService")
public class AdminServiceimpl  extends AbstractService  implements AdminService {
	
	@Autowired AdminMapper adminMapper;

	public List<Admin> findList() {
		return adminMapper.findList();
	}

	public Set<String> findRoles(String account) {
		return adminMapper.findRoles(account);
	}

	public Set<String> findResources(String account) {
		return adminMapper.findResources(account);
	}

	public Admin findByAccount(String account) {
		return adminMapper.findByAccount(account);
	}
	
	public List<AdminResourceVo> findAdminResourceVo(Integer adminId) {
		return adminMapper.findAdminResourceVo(adminId);
	}

}
