package com.didispace.test.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodContext {
	Method curMethod=null,pre=null,next=null;
	String descption; 
	MatchResultMethon curMRM=null;
	public MatchResultMethon getCurMRM()
	{
		return this.curMRM;
	}
	public MethodContext(Method md,MatchResultMethon c)
	{
		this.curMethod = md;
		this.curMRM = c;
	}
	public String invokeMethod(Object obj,Object[] parames) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		if(obj == null)
			obj = this.curMethod.getDeclaringClass().newInstance();
		Object o = this.curMethod.invoke(obj, parames);
		String curstr = o.toString();
		return curstr;
	}
	

}
