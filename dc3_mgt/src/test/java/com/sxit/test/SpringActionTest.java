package com.sxit.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sxit.mgt.system.service.FunctionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml",
		"classpath:conf/spring-mvc.xml", "classpath:conf/spring-mybatis-db.xml" })
@WebAppConfiguration
public class SpringActionTest {

	@Autowired
	private WebApplicationContext wac;

	// 模拟request,response
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	private MockMvc mockMvc;

	@Autowired
	private FunctionService functionService;


	// 执行测试方法之前初始化模拟request,response
	@Before
	public void setUp() {
		// this.mockMvc =
		// MockMvcBuilders.standaloneSetup(functionService).build();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		System.out.println(wac.getBeanDefinitionNames());

		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
	}

	@Test
	public void testList() throws Exception {

		try {
			System.out.println("==================");
			System.out.println("==================");

			MvcResult result = mockMvc.perform(get("/auth/initData")).andDo(print())
					.andExpect(status().isOk())
					.andReturn();
			
			System.out.println(result.getResponse().getContentAsString());
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
