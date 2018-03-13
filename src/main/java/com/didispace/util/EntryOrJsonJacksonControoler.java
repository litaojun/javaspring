package com.didispace.util;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.didispace.web.User;


/**
 * EntryOrJson
 * Jackson使用
 * @author Administrator
 *
 */
@Controller
public class EntryOrJsonJacksonControoler {

	private Logger log = Logger.getLogger(EntryOrJsonJacksonControoler.class);
	
	private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    private User user = null;
    private String json = null;
    
	public EntryOrJsonJacksonControoler() {
		objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json = "{\"age\":23,\"birthday\":\"2011-12-5\",\"password\":\"321\",\"sex\":\"man\",\"username\":\"wy\"}";
	}
	
	public void destroy(JsonGenerator jsonGenerator) throws IOException{
		if(jsonGenerator != null){
			jsonGenerator.flush();
		}
		if(!jsonGenerator.isClosed()){
			jsonGenerator.isClosed();
		}
	}
	/**
	 * 1、Entity(JavaBean/Model)转换成JSON 
	 *    JsonGenerator的writeObject方法和ObjectMapper的writeValue方法完成对Java对象的转换，二者传递的参数及构造的方式不同;
	 *    JsonGenerator的创建依赖于ObjectMapper对象,也就是说如果你要使用JsonGenerator来转换JSON，那么你必须创建一个ObjectMapper。
	 *    但是你用ObjectMapper来转换JSON，则不需要JSONGenerator。
	 */
	public void Entry2Json(){
		user = new User();
		user.setUsername("wy");
		user.setPassword("321");
		user.setAge(23);
		user.setSex("man");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ssd hh:mm:ss").format(new Date()));
		
		log.info("==============Java Bean >>> JSON Object==================");
		
		try {
			log.info("==============(JsonGenerator)Java Bean >>> JSON Object==================");
			jsonGenerator.writeObject(user);
			System.out.println();
			log.info("==============(ObjectMapper)Java Bean >>> JSON Object==================");
			objectMapper.writeValue(System.out, user);
			
			this.destroy(jsonGenerator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 2、将List集合转换成Json字符串 
	 *    
	 */
	public void list2Json(){
		List<User> userList = new ArrayList<User>();
		for(int i=0;i<3;i++){
			user = new User();
			user.setUsername("wy"+i);
			user.setPassword("321"+i);
			user.setAge(23+i);
			user.setSex("man"+i);
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ssd hh:mm:ss").format(new Date())+" "+i);
			
			userList.add(user);
		}
		
		log.info("==============Java List >>> JSON Object==================");
		
		try {
			log.info("==============(JsonGenerator)Java Bean >>> JSON Object==================");
			jsonGenerator.writeObject(userList);
			System.out.println();
			log.info("==============(ObjectMapper)Java Bean >>> JSON Object==================");
			System.out.println("ObjectMapper 第一种方式:"+objectMapper.writeValueAsString(userList));
			System.out.print("ObjectMapper 第二种方式:");
			objectMapper.writeValue(System.out, userList);
			
			this.destroy(jsonGenerator);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	/**
	 * 3、将Map集合转换成Json字符串
	 * 
	 */
	public void map2Json(){
		user = new User();
		user.setUsername("wy");
		user.setPassword("321");
		user.setAge(23);
		user.setSex("man");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", Boolean.TRUE);
		map.put("int", 321);
		map.put("Long", 321.01);
		map.put("Str", "wy");
		map.put("array", new String[]{"wy", "321"});
		map.put("func", "function(i){ return this.arr[i]; }"); 
		map.put("user", user);
		
		log.info("==============Java Map >>> JSON Object==================");
		
		try {
			log.info("==============(JsonGenerator)Java Bean >>> JSON Object==================");
			jsonGenerator.writeObject(map);
			System.out.println();
			log.info("==============(ObjectMapper)Java Bean >>> JSON Object==================");
			objectMapper.writeValue(System.out, map);
			
			this.destroy(jsonGenerator);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	/**
	 * 4、Jackson提供的一些类型，用这些类型完成json转换;
	 *    如果你使用这些类型转换JSON的话，那么你即使没有JavaBean(Entity)也可以完成复杂的Java类型的JSON转换。
	 */
	public void object2Json(){
		
		String[] arr = { "a", "b", "c" };
        String str = "hello world jackson!";
		try {
			log.info("==============(JsonGenerator)Java Bean >>> JSON Object==================");
			// byte
			jsonGenerator.writeBinary(str.getBytes());
			// boolean
			jsonGenerator.writeBoolean(true);
			// null
			jsonGenerator.writeNull();
			// float
			jsonGenerator.writeNumber(2.2f);
			// char
			jsonGenerator.writeRaw("c");
			// String
			jsonGenerator.writeRaw(str, 5, 10);
			// String
			jsonGenerator.writeRawValue(str, 5, 5);
			// String
			jsonGenerator.writeString(str);
			jsonGenerator.writeTree(JsonNodeFactory.instance.POJONode(str));
			System.out.println();
			System.out.println("-----------------------------------------");

			// Object
			jsonGenerator.writeStartObject();// {
			jsonGenerator.writeObjectFieldStart("user");// user:{
			jsonGenerator.writeStringField("name", "wy");// name:wy
			jsonGenerator.writeBooleanField("sex", true);// sex:true
			jsonGenerator.writeNumberField("age", 23);// age:23
			jsonGenerator.writeEndObject();// }

			jsonGenerator.writeArrayFieldStart("infos");// infos:[
			jsonGenerator.writeNumber(23);// 23
			jsonGenerator.writeString("this is array");// this is array
			jsonGenerator.writeEndArray();// ]
			
			jsonGenerator.writeEndObject();// }
			System.out.println();
			
			// complex Object
			jsonGenerator.writeStartObject();// {
			jsonGenerator.writeObjectField("infos", arr);// infos:[array]
			jsonGenerator.writeEndObject();// }

			this.destroy(jsonGenerator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 5、将json字符串转换成JavaBean对象
	 *    objectMapper.readValue()
	 *    第一个参数就是解析的JSON字符串，第二个参数是即将将这个JSON解析成Java对象的类型
	 */
	public void json2Entry(){
		try {
			log.info("==============JSON Object String >>> Java Bean ==================");
			User user = objectMapper.readValue(json, User.class);
			log.info(user);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 6、Json字符串转换成Array
	 */
	public void json2Array(){
		json = "[" + json + "]";
		try {
			log.info("==============JSON Object String >>> Array ==================");
			User[] user = objectMapper.readValue(json, User[].class);
			log.info(user);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 7、Json字符串转换Map集合
	 */
	public void json2Map(){
		json = "{\"wy\":"+ json +",\"success\":true}";

		try {
			log.info("==============JSON Object String >>> Map ==================");
			Map<?, ?> map = objectMapper.readValue(json, Map.class);
			log.info(map);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 8、Json字符串转换List集合
	 */
	public void json2List(){
		json = "[" + json + "]";
		try {
			log.info("==============JSON Object String >>> List ==================");
			List<?> list = objectMapper.readValue(json, List.class);
			log.info(list);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 9、将JSON返回到页面
	 */
	/*@RequestMapping(value="/returnJackson", method=RequestMethod.GET)
	public void commonReturnType(HttpServletResponse response){
		user = new User();
		user.setUsername("wy");
		user.setPassword("321");
		user.setAge(23);
		user.setSex("man");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		log.info("==============Java Bean >>> JSON Object==================");
		
		try {
			log.info("==============(ObjectMapper)Java Bean >>> JSON Object==================");
			objectMapper.writeValue(response.getWriter(), user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	/*@RequestMapping(value="/returnJackson", method=RequestMethod.GET)
	public void commonReturnType(PrintWriter out){
		user = new User();
		user.setUsername("wy");
		user.setPassword("321");
		user.setAge(23);
		user.setSex("man");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		log.info("==============Java Bean >>> JSON Object==================");
		
		try {
			log.info("==============(ObjectMapper)Java Bean >>> JSON Object==================");
			objectMapper.writeValue(out, user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	@RequestMapping(value="/returnJackson", method=RequestMethod.GET)
	public ModelAndView commonReturnType(){
	    user = new User();
		user.setUsername("wy");
		user.setPassword("321");
		user.setAge(23);
		user.setSex("man");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		log.info("==============Java Bean >>> JSON Object==================");
		ModelAndView mav = new ModelAndView();
		try {
			mav.addObject("json", objectMapper.writeValueAsString(user));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.setViewName("returnJson");
		return mav;
	}

}

