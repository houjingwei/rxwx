package com.rxwx.service.admin;

import java.util.List;

import com.rxwx.common.exception.CustomException;
import com.rxwx.model.Menu;

public interface MenuService {

	List<Menu> findAllMenu() throws CustomException;
}
