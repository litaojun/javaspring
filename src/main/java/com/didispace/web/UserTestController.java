package com.didispace.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestController {
	 private ObjectMapper objectMapper = new ObjectMapper();
	 //用户注册
	 @RequestMapping(value = "/b001.001.001", method = RequestMethod.POST)
	    public String paramfun(@RequestParam("phoneNo") String username,@RequestParam("password") String password,@RequestParam("nickname") String nickname) throws JsonGenerationException, JsonMappingException, IOException 
	    {
	    	UserInfo user = new UserInfo();
	    	user.setUsername(username);
	    	user.setPassword(password);
	    	user.setImgurl("http://www.cnblogs.com/skins/summerGarden/images/header.jpg");
	    	user.setNickname(nickname);
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("success", true);
	    	//map.put("user", user);
	    	String stra = objectMapper.writeValueAsString(map);
	    	System.out.println("stra="+stra);
	        return stra;
	    }
	 
	 //用户登录
	 @RequestMapping(value = "/b001.001.002", method = RequestMethod.POST)
	    public String userlogin(@RequestParam("phoneNo") String username,@RequestParam("password") String password) throws JsonGenerationException, JsonMappingException, IOException 
	    {
	    	UserInfo user = new UserInfo();
	    	user.setUsername(username);
	    	user.setPassword(password);
	    	user.setImgurl("ssss");
	    	user.setNickname("192.168.173.1");
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("success", true);
	    	map.put("session", "xxxxxxxxxxxx");
	    	//map.put("avatar","http://192.168.173.1:8081/xy/header.jpg");
	    	map.put("avatar","pic");
	    	map.put("nickname","fffff");
	    	//map.put("user", user);
	    	String stra = objectMapper.writeValueAsString(map);
	    	System.out.println("stra="+stra);
	        return stra;
	    }
	 
	 //用户修改
	 @RequestMapping(value = "/b001.001.003", method = RequestMethod.POST)
	    public String userupdate(@RequestParam("phoneNo") String username,@RequestParam("nickname") String nickname) throws JsonGenerationException, JsonMappingException, IOException 
	    {
	    	UserInfo user = new UserInfo();
	    	user.setUsername(username);
	    	//user.setPassword(password);
	    	user.setImgurl("ssss");
	    	//user.setNickname("http://192.168.43.120:8081/xy/header.jpg");
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("success", true);
	    	map.put("session", "xxxxxxxxxxxx");
	    	map.put("avatar","http://192.168.173.1:8081/xy/header.jpg");
	    	map.put("nickname","fffff");
	    	//map.put("user", user);
	    	String stra = objectMapper.writeValueAsString(map);
	    	System.out.println("stra="+stra);
	        return stra;
	    }
	 
	 //扫码登录
	 @RequestMapping(value = "/b001.001.006", method = RequestMethod.POST)
	    public String userscanlogin(@RequestParam("viewCode") String viewCode,@RequestParam("phoneNo") String phoneNo) throws JsonGenerationException, JsonMappingException, IOException 
	    {
		 System.out.println("扫码登录，对应参数：");
		 System.out.println("viewCode="+viewCode);
		 System.out.println("phoneNo="+phoneNo);
		 System.out.println("返回消息如下：");
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("success",true);
	    	map.put("session", "xxxxxxxxxxxx");
	    	map.put("avatar","http://192.168.43.120:8081/xy/header.jpg");
	    	map.put("nickname","fffff");
	    	//map.put("user", user);
	    	String stra = objectMapper.writeValueAsString(map);
	    	System.out.println("stra="+stra);
	        return stra;
	    }
	 
	 
	 //获取公钥
	 @RequestMapping(value = "/b000.001.001", method = RequestMethod.POST)
	    public String usergetpubkey(@RequestParam("keyAlias") String keyAlias) throws JsonGenerationException, JsonMappingException, IOException 
	    {
		     System.out.println("获取公钥接口，对应参数：");
	    	System.out.println("keyAlias="+keyAlias);
	    	System.out.println("返回消息如下：");
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("success",true);
	    	map.put("publicKey", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnU+Xkgq6mDJ1wwLZQC1U6+DZ49T/QH0asEJbbQIHRdvt5duq4w9hXPMp8wciKXwatABLEwOfuf4O0HBH5CFVNRPx80+WCG00xbmjYjf8tAEzh4WLIZ2zKayFtvr0kT4GG9k/IPR8cM8/F8Nse3IZuwCzoVY2QJijbWLFQPqT4Tqh3EQpCr+FoPZhHsdhzoijX7zfmF6rhVen7nYkRdMwv63v9zR5wNFSrpUafVtDeXQylWv5zhbdTsJ4+SD7ZLYfE9ejvW/td+Xyqyt1K5FTNHc8jcclfFf+hRRDcymV6AAM3QkxH2vHRoArw2RQpUi7uM30pvbguMqCL3+aMuWZewIDAQAB");

	    	//map.put("user", user);
	    	String stra = objectMapper.writeValueAsString(map);
	    	System.out.println("stra="+stra);
	        return stra;
	    }
	 
	 
	//获取公钥
		 @RequestMapping(value = "/list_1.json", method = RequestMethod.GET)
		    public String usernewsjson(@RequestParam("ctype") String ctype) throws JsonGenerationException, JsonMappingException, IOException 
		    {
			    System.out.println("获取公钥接口，对应参数：");
		    	System.out.println("ctype="+ctype);
		    	System.out.println("返回消息如下：");
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("success",true);
		    	//map.put("publicKey", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnU+Xkgq6mDJ1wwLZQC1U6+DZ49T/QH0asEJbbQIHRdvt5duq4w9hXPMp8wciKXwatABLEwOfuf4O0HBH5CFVNRPx80+WCG00xbmjYjf8tAEzh4WLIZ2zKayFtvr0kT4GG9k/IPR8cM8/F8Nse3IZuwCzoVY2QJijbWLFQPqT4Tqh3EQpCr+FoPZhHsdhzoijX7zfmF6rhVen7nYkRdMwv63v9zR5wNFSrpUafVtDeXQylWv5zhbdTsJ4+SD7ZLYfE9ejvW/td+Xyqyt1K5FTNHc8jcclfFf+hRRDcymV6AAM3QkxH2vHRoArw2RQpUi7uM30pvbguMqCL3+aMuWZewIDAQAB");
		    	ArrayList<News> newsl = new ArrayList<News>();
		    	Map<String, Object> testmap = new HashMap<String, Object>();
		    	for(int i=0;i<16;i++)
		    	{
		    		News news= new News();
		    		news.setListimage("http://www.cnblogs.com/skins/summerGarden/images/header.jpg");
		    		news.setPubdate(new Date().toString());
		    		news.setTitle("aaa"+i);
		    		news.setUrl("http://business.sohu.com/20160811/n463756319.shtml");
		    		newsl.add(news);
		    	}
		    	testmap.put("news", newsl);
		    	map.put("data", testmap);
		    	//map.put("user", user);
		    	String stra = objectMapper.writeValueAsString(map);
		    	System.out.println("stra="+stra);
		        return stra;
		    }
	 @RequestMapping(value = "/getuser", method = RequestMethod.GET)
	    public String getuser(@RequestParam("username") String username) throws JsonGenerationException, JsonMappingException, IOException 
	    {
	    	UserInfo user = new UserInfo();
	    	user.setUsername(username);
	    	user.setPassword("123456");
	    	user.setImgurl("ssss");
	    	user.setNickname("xxxx");
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("retcode", 0);
	    	map.put("user", user);
	    	String stra = objectMapper.writeValueAsString(map);
	    	System.out.println("stra="+stra);
	        return stra;
	    }
}
