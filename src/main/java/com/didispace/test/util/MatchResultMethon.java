package com.didispace.test.util;

import java.lang.reflect.Method;

public class MatchResultMethon 
{
     int matchType;
     int[] caseid;
     String infacename;
     Class cls;
     public Class reqcls=null;
     MethodContext a;
     public MatchResultMethon next=null,pre=null;
     public MatchResultMethon(int matchtype,int[] caseid,String infname,Method md,Class cls)
     {
    	 this.matchType = matchtype;
    	 this.caseid = caseid;
    	 this.infacename = infname;
    	 this.cls = cls;
    	 a = new MethodContext(md,this);
     }
     public Class getParamerClass()
     {
    	 return this.cls;
     }
     public MethodContext getMethodContext()
     {
    	 return this.a;
     }
     public  MethodContext getMatchMethodContext(String strcaseid)
     {
    	 MethodContext retmct = null;
    	 MatchResultMethon cur  = this;
    	 while(cur!=null)
    	 {
    		 if(!cur.isMatchCase(strcaseid))
    		 {
    			 cur = cur.next;
    		 }
    		 else
    		 {
    			 retmct = cur.getMethodContext();
    			 break;
    		 }
    	 }
		return retmct;
    	 
     }
     public boolean isMatchCase(String strcaseid)
     {
    	 boolean sign = false;
    	 int num = MatchResultMethon.getNumByCaseid(strcaseid);
    	 switch(matchType)
    	 {
    	 case(0):
    		 sign = true;
    		 break;
    	 case(1):
    		 for(int i=0;i<this.caseid.length;i++ )
    		 {
    			 if(num == this.caseid[i])
    			 {
    				 sign = true;
    			     break;
    			 }
    		 }
    		 break;
    	 case(2):
    		 if(num>=this.caseid[0] && num<this.caseid[1])
    		    sign=true;
    		 break;
    	 case(3):
    		 if(num>=this.caseid[0] && num<this.caseid[1])
     		    sign=true;
    		 else
		    	 for(int i=2;i<this.caseid.length;i++ )
				 {
					 if(num == this.caseid[i])
					 {
						 sign = true;
					     break;
					 }
				 }
	         break;
    	 }
    	 return sign;
     }
     public boolean compare(int a)
     {
    	 boolean ret = false;
    	 ret = (this.matchType > a);
    	 return ret;
     }
     public static int getNumByCaseid(String caseid)
     {
    	 int a = 0;
    	 String[] rs = caseid.split("_");
    	 a = Integer.parseInt(rs[rs.length-1]);
    	 return a;
     }
}
