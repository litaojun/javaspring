package com.didispace.test.core;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.didispace.test.web.TestContorl;

public class TestTestContorl2 {
	private MockMvc mvc;
	private MockMvc mvcrs;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new TestContorl()).build();
		mvcrs = MockMvcBuilders.standaloneSetup(new TestContorl()).build();
		
	}

	@Test
	public void getHello1() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_1");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello7() throws Exception
	{
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_7");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
			
	}
	
}
