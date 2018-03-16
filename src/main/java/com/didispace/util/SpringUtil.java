package com.didispace.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.didispace.dao.impl.TestCaseRecord;
import com.didispace.dao.mapper.TestCaseRecordMapper;




/**
 * spring工具类
 * @author 
 *
 */
public class SpringUtil {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TestCaseRecordMapper us = (TestCaseRecordMapper) getBean("testCaseRecordMapper");
		TestCaseRecord at = us.selectByPrimaryKey(551);
		System.out.println(at.getClassname());
		
	}

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

	public static Object getBean(String beanName) {
		String[] a = ctx.getBeanDefinitionNames();
		for(String m:a)
			System.out.println(m);
		return ctx.getBean(beanName);
	}

}
