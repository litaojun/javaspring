package com.didispace.test.core;

import java.util.HashMap;

import com.didispace.test.util.HttpRequest;

public class TestDataManager
{
	HashMap<String,TestData> casedata = new HashMap<String,TestData>();
	public String getReqdata(String caseid,String infacename)
	{
		String ret=null;
		if(casedata.containsKey(caseid))
		{
			TestData td = casedata.get(caseid);
			ret = td.reqdata;
		}
		else
		{
			ret = HttpRequest.sendGet(CaseConfig.requrl, String.format("caseid=%s&intfacename=%s", new String[]{caseid,infacename}));
			TestData ntd = new TestData();
			ntd.reqdata = ret;
			casedata.put(caseid, ntd);
		}
		return ret;
	}
	
	public String getRetdata(String caseid,String infacename)
	{
		String ret=null;
		TestData td = casedata.get(caseid);
		ret = td.retdata;
		if(ret==null)
		{
			ret = HttpRequest.sendGet(CaseConfig.retcodeurl, String.format("caseid=%s&intfacename=%s", new String[]{caseid,infacename}));
			td.retdata = ret;
		}
		return ret;
	}
	public String getResultdata(String caseid,String infacename)
	{
		String ret=null;
		TestData td = casedata.get(caseid);
		ret = td.resultdata;
		if(ret==null)
		{
			ret = HttpRequest.sendGet(CaseConfig.yqresulturl, String.format("caseid=%s&intfacename=%s", new String[]{caseid,infacename}));
			td.resultdata = ret;
		}
		return ret;
	}
	
	public void setReqdata(String caseid,String reqdt)
	{
		
		if(casedata.containsKey(caseid))
		{
			TestData td = casedata.get(caseid);
			td.reqdata = reqdt;
		}
		else
		{
			TestData newtd = new TestData();
			newtd.reqdata = reqdt;
			casedata.put(caseid, newtd);
		}
		
	}
	public void setRetdata(String caseid,String retdt)
	{
		TestData td = casedata.get(caseid);
		td.retdata = retdt;
		
	}
	public void setResult(String caseid,String resultdata)
	{
		TestData td = casedata.get(caseid);
		td.resultdata = resultdata;
	}

	public static class TestData{
		public String reqdata=null;
		public String retdata=null;
		public String resultdata=null;
	}
}
