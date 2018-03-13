package com.didispace.test.tcase.infs;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.didispace.test.util.TestCase;

public class TestUserGetInterface 
{
	 private ObjectMapper objectMapper = new ObjectMapper();
	 @TestCase(ifname = "useradd", cstype = 0,rule = {}, cls = UserAddInfo.class)
	 public String paramfunsstt0(UserAddInfo uaif) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		   System.out.println("paramfunsstt0");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @TestCase(ifname = "useradd", cstype = 1,rule = {5,8}, cls = UserAddInfo.class)
	 public String paramfunsstt1(UserAddInfo uaif) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("paramfunsstt1");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @TestCase(ifname = "useradd", cstype = 1,rule = {14}, cls = UserAddInfo.class)
	 public String paramfunsstt11(UserAddInfo uaif) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("paramfunsstt11");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @TestCase(ifname = "useradd", cstype = 2,rule = {3,5}, cls = UserAddInfo.class)
	 public String paramfunsstt2(UserAddInfo uaif) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("paramfunsstt2");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @TestCase(ifname = "useradd", cstype = 2,rule = {9,11}, cls = UserAddInfo.class)
	 public String paramfunsstt21(UserAddInfo uaif) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("paramfunsstt21");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @TestCase(ifname = "useradd", cstype = 3,rule = {1,3,6,7}, cls = UserAddInfo.class)
	 public String paramfunsstt3(UserAddInfo uaif) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("paramfunsstt3");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @TestCase(ifname = "useradd", cstype = 3,rule = {11,13,15,17}, cls = UserAddInfo.class)
	 public String paramfunsstt31(UserAddInfo uaif) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("paramfunsstt31");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	
}
