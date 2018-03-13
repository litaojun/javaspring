package com.didispace.util;

import java.util.ArrayList;

import com.didispace.web.User;

public class OrderImplList {
	private String odrid;
	private ArrayList<User> userlist;
	private int sarlay;

	public OrderImplList()
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
	public void setUserlist(ArrayList<User> userlist)
	{
		this.userlist = userlist;
	}
	public ArrayList<User> getUserlist()
	{
		return this.userlist;
	}
}
