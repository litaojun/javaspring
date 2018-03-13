package com.didispace.test.tcase.rstcpr;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.didispace.test.tcase.infs.UserAddInfo;
import com.didispace.test.tcase.infs.UserAddRsp;
import com.didispace.test.util.ResultCompare;

public class TestUserGetResultMatch {
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@ResultCompare(ifname = "useradd", cstype = 0,rule = {}, cls = Class.class)
	 public String matchparamfunsstt0(String rspinf,UserAddInfo uaif,String yqrst) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		    System.out.println("matchparamfunsstt0");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @ResultCompare(ifname = "useradd", cstype = 1,rule = {5,8}, cls = Class.class)
	 public String matchparamfunsstt1(String rspinf,UserAddInfo uaif,String yqrst) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		    System.out.println("matchparamfunsstt1");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @ResultCompare(ifname = "useradd", cstype = 1,rule = {14}, cls = Class.class)
	 public String matchparamfunsstt11(String rspinf,UserAddInfo uaif,String yqrst) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("matchparamfunsstt11");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @ResultCompare(ifname = "useradd", cstype = 2,rule = {3,5}, cls = Class.class)
	 public String matchparamfunsstt2(String rspinf,UserAddInfo uaif,String yqrst) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("matchparamfunsstt2");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @ResultCompare(ifname = "useradd", cstype = 2,rule = {9,11}, cls = Class.class)
	 public String matchparamfunsstt21(String rspinf,UserAddInfo uaif,String yqrst) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("matchparamfunsstt21");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @ResultCompare(ifname = "useradd", cstype = 3,rule = {1,3,6,7}, cls = UserAddRsp.class)
	 public String matchparamfunsstt3(String rspinf,UserAddInfo uaif,UserAddRsp yqrst) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		    System.out.println("matchparamfunsstt3");
//		    System.out.println("rspinf="+rspinf);
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
//	    	System.out.println("yqrst="+yqrst);
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 @ResultCompare(ifname = "useradd", cstype = 3,rule = {11,13,15,17}, cls = Class.class)
	 public String matchparamfunsstt31(String rspinf,UserAddInfo uaif,String yqrst) throws JsonGenerationException, JsonMappingException, IOException 
	 {
//		 System.out.println("matchparamfunsstt31");
//	    	System.out.println(String.format("name=%s,age=%s,nickname=%s", new String[]{uaif.getUsername(),uaif.getPassword(),uaif.getNickname()}));
	        HashMap<String,Object> hmp = new 	HashMap<String,Object>();
	        hmp.put("retcode", 2);
	        hmp.put("user", uaif);
	        String stra = objectMapper.writeValueAsString(hmp);
	        return stra ;
	 }
	 public static void main(String[] args)
	 {
		 Class a = UserAddInfo.class;
		 Class b = Class.class;
		 Class c = UserAddInfo.class;
		 if(a==b)
		 {
			 System.out.println("aaaa");
		 }
		 if(a==c)
		 {
			 System.out.println("bbbbb");
		 }
		 if(a.equals(b))
		 {
			 System.out.println("ccccc");
		 }
		 if(a.equals(c))
		 {
			 System.out.println("ddddd");
		 }
	 }

}
