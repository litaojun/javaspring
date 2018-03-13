package com.didispace.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.didispace.web.User;

public interface HelloWorldService {
     public User getNewName(String userName,int age) throws JsonParseException, JsonMappingException, IOException; 
     public User getUserByid(String id);
     
}


