package com.rxwx.service.admin;

import java.util.List;

import com.rxwx.common.exception.CustomException;
import com.rxwx.vo.MenuResourceVo;

public interface MenuResourceService {
	
	/**
	 * 账户对应的菜单
	 * @param id
	 * @return
	 */
	List<MenuResourceVo> userMenuList(Integer adminId) throws CustomException;

}
