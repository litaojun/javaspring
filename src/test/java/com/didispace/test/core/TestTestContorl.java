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

public class TestTestContorl {
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
	public void getHello2() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_2");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
			}
	@Test
	public void getHello3() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_3");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello4() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_4");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello5() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_5");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello6() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_6");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello7() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_7");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello8() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_8");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello9() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_9");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello10() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_10");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello11() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_11");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello12() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_12");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello13() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_13");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello14() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_14");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello15() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_15");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getHello16() throws Exception {
		MultiValueMap<String, String> mvm =  new LinkedMultiValueMap<String, String>();
		mvm.add("intfacename", "useradd");
		mvm.add("caseid", "test_sdf_16");
		mvc.perform(MockMvcRequestBuilders.get("/interfaces").params(mvm).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
		mvcrs.perform(MockMvcRequestBuilders.get("/resultCompare").params(mvm).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello World")));
	}
	
	public void getSayWorld() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/resultCompare").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello sayhello")));
	}
}
