package com.didispace.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.didispace.service.HelloWorldService;



@RestController
public class JsonDataController 
{

    private ObjectMapper objectMapper = new ObjectMapper();
    //private JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(f, enc)
	 @Autowired
     @Qualifier("helloWorldServiceTest")   
     private HelloWorldService helloWorldService;
	 
	@RequestMapping(value = "/userjson", method = RequestMethod.GET)
    public User indexget(@RequestBody User  user)
	{
        return user;
    }
	
	@RequestMapping(value = "/userjson", method = RequestMethod.POST)
    public User indexpost(@RequestBody User  user)
	{
        return user;
    }
	
	@RequestMapping(value = "/userparam" , method = RequestMethod.GET)
    public User testparam(@RequestParam("name") String name,@RequestParam("age") int age) throws JsonParseException, JsonMappingException, IOException
	{
		User user = helloWorldService.getNewName(name,age);
        return user;
    }
	
	@RequestMapping(value = "/userparam" , method = RequestMethod.POST)
    public String testparampost(@RequestParam("name") String name,@RequestParam("age") int age) throws JsonParseException, JsonMappingException, IOException
	{
		User user = helloWorldService.getNewName(name,age);
		String jsonuser = objectMapper.writeValueAsString(user);
        return jsonuser;
    }
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public String testPathVariable(@PathVariable("id") String id ) throws JsonParseException, JsonMappingException, IOException
	{
		User user = helloWorldService.getUserByid(id);
		String jsonuser = objectMapper.writeValueAsString(user);
        return jsonuser;
    }
}
