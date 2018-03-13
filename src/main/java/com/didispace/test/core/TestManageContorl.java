package com.didispace.test.core;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.didispace.test.util.AnnotationFilterClass;
import com.didispace.test.util.ClassUtils;
import com.didispace.test.util.MatchResultMethon;
import com.didispace.test.util.ResultCompare;
import com.didispace.test.util.TestCase;

public class TestManageContorl 
{
    public static Map<String,MatchResultMethon> interfacemethod = null;
    public static Map<String,MatchResultMethon> resultmethod  = null;
	 public TestManageContorl() throws ClassNotFoundException, IOException
	 {
		 TestManageContorl.init();
	 }
	 public static void init() throws ClassNotFoundException, IOException
	 {
		 if(TestManageContorl.interfacemethod == null)
		 {
			 TestManageContorl.interfacemethod = new HashMap<String,MatchResultMethon>();
			 initInterfacemethod();
		 }
		 if(TestManageContorl.resultmethod == null)
		 {
			 TestManageContorl.resultmethod = new HashMap<String,MatchResultMethon>();
			 initResultmethod();
		 }
	 }
	 public static Map<String,MatchResultMethon> getInterfacemethod() throws ClassNotFoundException, IOException
	 {
		 if(interfacemethod==null)
			 TestManageContorl.init();
		 return interfacemethod;
	 }
	 public static Map<String,MatchResultMethon> getResultmethod() throws ClassNotFoundException, IOException
	 {
		 if(resultmethod==null)
			 TestManageContorl.init();
		 return resultmethod;
	 }

     public static void initInterfacemethod() throws ClassNotFoundException, IOException
     {
    	 ArrayList<Class>  x = ClassUtils.filterClassByKey("Interface","com.didispace.test");
    	//System.out.println("xxx="+x.size());
//    	 for(Class s : x)
//    		 System.out.println(s.getName());
    	 ArrayList<Method> als = AnnotationFilterClass.filterMethodListByAnnotation( x, TestCase.class);
    	 for(Method md:als)
    	 {
    		Annotation[] ans =  md.getAnnotations();
    		for(Annotation an:ans)
    		{
    			if(an instanceof TestCase)
    			{
    				TestCase tcs = (TestCase) an;
    				putInterfacemethod(tcs,md);
    				break;
    			}
    		}
    		 //System.out.println(md.getName());
    	 }

     }
     public static void putInterfacemethod(TestCase tc,Method md)
     {
    	// System.out.println("putInterfacemethod="+md.getName()+"--class--"+md.getDeclaringClass());
    	 String ifname = tc.ifname();
    	 MatchResultMethon curmactch = new MatchResultMethon(tc.cstype(),tc.rule(),tc.ifname(),md,tc.cls());
    	 if(interfacemethod.containsKey(ifname))
    	 {
    		 MatchResultMethon mm = interfacemethod.get(ifname);
    		 while(mm!=null)
    		 {
    			 if(mm.compare(tc.cstype()) && mm.next!=null)
    			 {
    				 mm = mm.next;
    			 }
    			 else
    			 {
    				 if(mm.next!=null || !mm.compare(tc.cstype())  )
    				 {
	    				 curmactch.next = mm;
	    				 curmactch.pre = mm.pre;
	    				 mm.pre = curmactch;
	    				 if(curmactch.pre == null)
	    				 {
	    					 interfacemethod.remove(ifname);
	    					 interfacemethod.put(ifname, curmactch);
	    				 }
    				 }
    				 else
//    					 if(!mm.compare(tc.cstype()))
//    					 {
//    						 
//    					 }
//    					 else
	    				 {
	    					 mm.next = curmactch;
	    					 curmactch.pre = mm;
	    				 }
    				 break;
    			 }
    		 }
    	 }
    	 else
    	 {
    		 interfacemethod.put(ifname, curmactch);
    	 }
     }
     
     public static void initResultmethod() throws ClassNotFoundException, IOException
     {
    	 ArrayList<Class>  x = ClassUtils.filterClassByKey("ResultMatch","com.didispace.test");
    	// System.out.println("xxx="+x.size());
//    	 for(Class s : x)
//    		 System.out.println(s.getName());
    	 ArrayList<Method> als = AnnotationFilterClass.filterMethodListByAnnotation( x, ResultCompare.class);
    	 for(Method md:als)
    	 {
    		Annotation[] ans =  md.getAnnotations();
    		for(Annotation an:ans)
    		{
    			if(an instanceof ResultCompare)
    			{
    				ResultCompare tcs = (ResultCompare) an;
    				putResultComparemethod(tcs,md);
    				break;
    			}
    		}
    		 //System.out.println(md.getName());
    	 }

     }
     public static void putResultComparemethod(ResultCompare tc,Method md)
     {
    	// System.out.println("putResultComparemethod="+md.getName()+"--class--"+md.getDeclaringClass());
    	 String ifname = tc.ifname();
    	 MatchResultMethon curmactch = new MatchResultMethon(tc.cstype(),tc.rule(),tc.ifname(),md,tc.cls());
    	 MatchResultMethon infmatch = interfacemethod.get(ifname);
    	 curmactch.reqcls = infmatch.getParamerClass();
    	 if(resultmethod.containsKey(ifname))
    	 {
    		 MatchResultMethon mm = resultmethod.get(ifname);
    		 while(mm!=null)
    		 {
    			 if(mm.compare(tc.cstype()) && mm.next!=null)
    			 {
    				 mm = mm.next;
    			 }
    			 else
    			 {
    				 if(mm.next!=null || !mm.compare(tc.cstype()))
    				 {
	    				 curmactch.next = mm;
	    				 curmactch.pre = mm.pre;
	    				 mm.pre = curmactch;
	    				 if(curmactch.pre == null)
	    				 {
	    					 resultmethod.remove(ifname);
	    					 resultmethod.put(ifname, curmactch);
	    				 }
    				 }
    				 else
    				 {
    					 mm.next = curmactch;
    					 curmactch.pre = mm;
    				 }
    				 break;
    			 }
    		 }
    	 }
    	 else
    	 {
    		 resultmethod.put(ifname, curmactch);
    	 }
     }
     
}
