package com.didispace.util;

import com.didispace.web.User;

public class OrderImpl {
	private String odrid;
	private User user;
	private int sarlay;

	public OrderImpl()
	{
		 
	}
	public void setOdrid(String odrid)
	{
		this.odrid = odrid;
	}
	public String getOdrid()
	{
		return this.odrid;
	}
	public void setSarlay(int sarlay)
	{
		this.sarlay = sarlay;
	}
	public int getSarlay()
	{
		return this.sarlay;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public User getUser()
	{
		return this.user;
	}

}
