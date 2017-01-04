package com.rxwx.service.admin;

import java.util.List;

import com.rxwx.common.exception.CustomException;
import com.rxwx.vo.SysMenuVo;

public interface ResourceService {
	
	List<SysMenuVo> findMenu() throws CustomException;

}
