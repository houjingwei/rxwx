package com.rxwx.admin.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxwx.admin.mapper.ResourceMapper;
import com.rxwx.common.exception.CustomException;
import com.rxwx.core.dao.AbstractService;
import com.rxwx.model.Resource;
import com.rxwx.service.admin.ResourceService;
@Service(value = "resourceService")
public class ResourceServiceimpl  extends AbstractService  implements ResourceService {

	
	@Autowired ResourceMapper resourceMapper;
	
	public List<Resource> findAdminResourceByAdminId(Integer adminId,Integer type) throws CustomException {
		 Map<String,Integer> map=new HashMap<String,Integer>();  
        map.put("adminId", adminId);  
        map.put("type", type ); 
		return resourceMapper.findAdminResourceByAdminId(map);
	}

	
	

}
