package com.didispace.test.tcase.infs;

public class UserAddRsp {
	private int retcode;
	private String errstr;
	public void setRetcode(int cde)
	{
		this.retcode = cde;
	}
	public int getRetcode()
	{
		return this.retcode;
	}
	public void setErrstr(String s)
	{
		this.errstr = s;
	}

	public String getErrstr()
	{
		return this.errstr;
	}
}
