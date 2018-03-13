package com.didispace;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.didispace.filter.TestFilter;
import com.didispace.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.CookieResultMatchers;
import org.springframework.test.web.servlet.result.FlashAttributeResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.result.RequestResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.result.ViewResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class Chapter1ApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).addFilters(new TestFilter()).build();
		
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getSayWorld() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/sayhello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello sayhello")));
	}
	@Test
	public void getUser() throws Exception {
		JSONObject jsb = JSON.parseObject("{'username':'wy','password':'321','age':23,'sex':'man','birthday':'2016-07-27 05:00:5427 05:00:54'}");
		mvc.perform(MockMvcRequestBuilders.get("/test").contentType(MediaType.APPLICATION_JSON).content(jsb.toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"username\":\"wy\",\"password\":\"321\",\"age\":23,\"sex\":\"man\",\"birthday\":\"2016-07-27 05:00:5427 05:00:54\"}")));
	}
	@Test
	public void getparamtest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/paramtest").param("name", "litaojun").param("age", "5").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("litaojun5")));
	}
	@Test
	public void getparamtests() throws Exception 
	{
		MockHttpServletRequestBuilder a = MockMvcRequestBuilders.get("/{test}", new String[]{"litaojun"});
		MockHttpServletRequestBuilder b = MockMvcRequestBuilders.get("/paramtest");
		b.param("name", "test");
		b.param("age", "9");
		b.accept(MediaType.APPLICATION_JSON);
		ResultActions ras = mvc.perform(b);
		RequestResultMatchers mms = MockMvcResultMatchers.request();
		ModelResultMatchers  mmsmod = MockMvcResultMatchers.model();
		ViewResultMatchers viewm = MockMvcResultMatchers.view();
		FlashAttributeResultMatchers flashm = MockMvcResultMatchers.flash();
		StatusResultMatchers statusm = MockMvcResultMatchers.status();
		HeaderResultMatchers headerm = MockMvcResultMatchers.header();
		CookieResultMatchers cookm = MockMvcResultMatchers.cookie();
		ContentResultMatchers contentm = MockMvcResultMatchers.content();
		ras.andExpect(statusm.isOk()).andExpect(contentm.json(""));
		ras.andExpect(mms.sessionAttribute("aaa", "bbbb"));
		ResultHandler handls = MockMvcResultHandlers.print();
		ras.andDo(handls);
		MvcResult mvcrs = ras.andReturn();
		
		mvc.perform(MockMvcRequestBuilders.get("/paramtest").content("name=test&age=9").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("litaojun5")));
	}

}
