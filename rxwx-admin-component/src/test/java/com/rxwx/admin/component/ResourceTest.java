package com.rxwx.admin.component;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rxwx.service.admin.ResourceService;
import com.rxwx.vo.BtnMenuVo;
import com.rxwx.vo.ResMenuVo;
import com.rxwx.vo.SysMenuVo;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class) // 整合
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ResourceTest extends TestCase {

	@Autowired ResourceService resourceService;

	@Test
	public void allMenu() {
		List<SysMenuVo> list = resourceService.findMenu();
		for (SysMenuVo sysMenuVo : list) {
			System.out.println(sysMenuVo.getName());
			for (ResMenuVo resMenuVo : sysMenuVo.getResMenuVoList()) {
				System.out.println("  |-"+resMenuVo.getName());
				for (BtnMenuVo btnMenuVo : resMenuVo.getBtnMenuVoList()) {
					System.out.println("    |-"+btnMenuVo.getName());
				}
			}
		}
	}

}
