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
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.didispace.web.User;

public class JsonTranTest {
	private Logger log = Logger.getLogger(EntryOrJsonJacksonControoler.class);
	private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
	public JsonTranTest()
	{
		 objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = "{\"age\":23,\"birthday\":\"2011-12-5\",\"password\":\"321\",\"sex\":\"man\",\"username\":\"wy\"}";
	
	}
	public String Entry2Json() throws JsonGenerationException, JsonMappingException, IOException{
		String retstr = null;
		User user = new User();
		user.setUsername("wy");
		user.setPassword("321");
		user.setAge(23);
		user.setSex("man");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ssd hh:mm:ss").format(new Date()));
		log.info("==============Java Bean >>> JSON Object==================");
		retstr = objectMapper.writeValueAsString(user);
		return retstr;	
	}
	public String list2Json() throws JsonGenerationException, JsonMappingException, IOException{
		List<User> userList = new ArrayList<User>();
		for(int i=0;i<3;i++){
			User user = new User();
			user.setUsername("wy"+i);
			user.setPassword("321"+i);
			user.setAge(23+i);
			user.setSex("man"+i);
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ssd hh:mm:ss").format(new Date())+" "+i);
			userList.add(user);
		}
		log.info("==============Java List >>> JSON Object==================");
		String retstr = null;
		retstr = this.objectMapper.writeValueAsString(userList);
		return retstr;
	}
	
	
	/**
	 * 3、将Map集合转换成Json字符串
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	public String map2Json() throws JsonGenerationException, JsonMappingException, IOException
	{
		User user = new User();
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
		String retstr = null;
		retstr = this.objectMapper.writeValueAsString(map);
		return retstr;
	}
	
	
    /** 
     * 5、将json字符串转换成JavaBean对象 
     *    objectMapper.readValue() 
     *    第一个参数就是解析的JSON字符串，第二个参数是即将将这个JSON解析成Java对象的类型 
     */  
    public User json2Entry(String json){  
    	User user =null;
        try {  
            log.info("==============JSON Object String >>> Java Bean ==================");  
             user = objectMapper.readValue(json, User.class);  
            
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
        return user;
    }  
    
    
    /** 
     * 6、Json字符串转换成Array 
     */  
    public User[] json2Array(String json){  
        //json = "[" + json + "]";  
    	User[] user = null;
        try {  
            log.info("==============JSON Object String >>> Array ==================");  
             user = objectMapper.readValue(json, User[].class);  
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
        return user;
    }  
    /** 
     * 7、Json字符串转换Map集合 
     */  
    public Map<?, ?> json2Map(String json){  
        //json = "{\"wy\":"+ json +",\"success\":true}";  
    	Map<?, ?> map = null;
        try {  
            log.info("==============JSON Object String >>> Map ==================");  
             map = objectMapper.readValue(json, Map.class);  
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
        return map;
    }  
//	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException
//	{
//		JsonTranTest jtt = new JsonTranTest();
//		String retstr = jtt.Entry2Json();
//		System.out.println("retstr="+retstr);
//		User user = jtt.json2Entry(retstr);
//		System.out.println("user="+user.getBirthday());
//		 retstr = jtt.list2Json();
//		 System.out.println("retstr="+retstr);
//		 User[] arruser = jtt.json2Array(retstr);
//		System.out.println("User[] arruser =="+arruser.length+"-----------"+arruser[0].getBirthday());
//		 retstr = jtt.map2Json();
//		System.out.println("retstr="+retstr);
//		Map<?,?> map  = jtt.json2Map(retstr);
//	}

}
