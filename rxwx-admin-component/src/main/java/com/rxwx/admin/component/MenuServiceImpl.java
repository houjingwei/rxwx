package com.rxwx.admin.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.admin.mapper.MenuMapper;
import com.rxwx.common.exception.CustomException;
import com.rxwx.core.dao.AbstractService;
import com.rxwx.model.Menu;
import com.rxwx.service.admin.MenuService;


@Service(value = "menuService")
public class MenuServiceImpl extends AbstractService  implements MenuService {

	
	@Autowired MenuMapper menuMapper;
	
	public List<Menu> findAllMenu() throws CustomException {
		
		return menuMapper.findAllMenu();
	}

}
