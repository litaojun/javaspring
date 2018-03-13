package com.didispace.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.didispace.dao.UserDao;
import com.didispace.service.HelloWorldService;
import com.didispace.web.User;



@Service("helloWorldServiceTest")
public class HelloWorldServiceImpl implements HelloWorldService {

	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
    @Qualifier("UserDaoTest")   
	private UserDao userdao;

	@Override
	public User getNewName(String userName,int age) throws JsonParseException, JsonMappingException, IOException 
    {
		
    	JSONObject jsb= new JSONObject();
    	jsb.put("userName", userName);
    	jsb.put("age", Integer.valueOf(age));
    	User user = objectMapper.readValue(jsb.toString(), User.class);
        return user;
    }
	
	@Override
	public User getUserByid(String id)
	{
		return userdao.getUserByIdFromDB(id);
	}

}