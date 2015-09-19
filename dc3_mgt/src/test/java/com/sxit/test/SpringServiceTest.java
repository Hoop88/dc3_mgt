package com.sxit.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import cn.com.sxit.weixin.entity.TSystemParamsBean;

import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.mgt.common.service.CommonService;
import com.sxit.mgt.system.service.FunctionService;
import com.sxit.model.system.SysFunction;

@SpringApplicationContext({ "classpath:conf/spring.xml",
		 "classpath:conf/spring-mybatis-db.xml" })
public class SpringServiceTest extends UnitilsJUnit4 {

	@SpringBean("functionService")
	private FunctionService functionService;

	@SpringBean("commonService")
	private CommonService commonService;
 
	@Before
	public void before() {

	}
	
	@Test
	public void getSysParamsList() throws Exception {
		
		
		Map map = new HashMap();
		
		try{
			
			// List<SysParams> list =	commonService.getParamsList(map);
			 
			 List<TSystemParamsBean> list =	commonService.querySystemParamList();
			 for(TSystemParamsBean p:list)
			 {
				 System.out.println(p.getParamsName());
			 }
		}catch(Exception e){
			e.printStackTrace();
			
		}

		
	}
	
	
	public void getList() throws Exception {

		PageVo page = new PageVo(1, 0);

		Map map = new HashMap();
		map.put("property_corp_name", "测试");

		Page<SysFunction> list = functionService.getFunctionList(page, map);

		for (SysFunction function : list) {
			System.out.println(function.getFunctionName());
		}

		System.out.println("当前页数:" + list.getPageNum());
		System.out.println("每页记录数:" + list.getPageSize());
		System.out.println("记录总数:" + list.getTotal());
	}

}
