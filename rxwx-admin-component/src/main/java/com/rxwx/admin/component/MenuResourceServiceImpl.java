package com.rxwx.admin.component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.common.exception.CustomException;
import com.rxwx.core.dao.AbstractService;
import com.rxwx.model.Menu;
import com.rxwx.model.Resource;
import com.rxwx.service.admin.AdminService;
import com.rxwx.service.admin.MenuResourceService;
import com.rxwx.service.admin.MenuService;
import com.rxwx.vo.AdminResourceVo;
import com.rxwx.vo.MenuResourceVo;


@Service(value = "menuResourceService")
public class MenuResourceServiceImpl extends AbstractService implements MenuResourceService {

	
	@Autowired AdminService adminService;
	@Autowired MenuService menuService;
	
	public List<MenuResourceVo> userMenuList(Integer adminId) {
		List<MenuResourceVo> voList = null;
		List<AdminResourceVo> resList = adminService.findAdminResourceVo(adminId);
		List<Menu> menuList = menuService.findAllMenu();
		if(null!=menuList && menuList.size()>0){
			voList = new ArrayList<MenuResourceVo>();
			for (Menu menu : menuList) {
				for (AdminResourceVo res : resList) {
					if(res.getMenuId()==menu.getId()){
						MenuResourceVo vo = new MenuResourceVo();
						vo.setMenuId(menu.getId());
						vo.setMenuName(menu.getName());
						voList.add(vo);
					}
				}
			}
		}
		
		
		if(null!=voList && voList.size()>0){
			for (MenuResourceVo mr : voList) {
				List<Resource> reslist = new ArrayList<Resource>();
				for (AdminResourceVo arVo : resList) {
					Resource res = null;
					if(arVo.getMenuId()==mr.getMenuId()){
						res = new Resource();
						try {
							BeanUtils.copyProperties(res, arVo);
							reslist.add(res);
						} catch (CustomException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				mr.setResList(reslist);
			}
		}
		System.out.println("菜单总数量:"+voList.size());
		return voList;
	}

}
