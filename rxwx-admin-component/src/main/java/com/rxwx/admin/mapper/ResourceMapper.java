package com.rxwx.admin.mapper;

import java.util.List;
import java.util.Map;

import com.rxwx.model.Resource;

public interface ResourceMapper {

	List<Resource> findAdminResourceByAdminId(Map<String, Integer> map);

}
