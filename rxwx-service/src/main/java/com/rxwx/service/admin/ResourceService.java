package com.rxwx.service.admin;

import java.util.List;

import com.rxwx.common.exception.CustomException;
import com.rxwx.model.Resource;

public interface ResourceService {
	
	List<Resource> findAdminResourceByAdminId(Integer adminId,Integer type) throws CustomException;
	
	
}
