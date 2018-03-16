package com.didispace.test.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.test.core.TestDataManager;
import com.didispace.test.core.TestManageContorl;
import com.didispace.test.dao.impl.TestCaseRecord;
import com.didispace.test.dao.impl.TestPlan;
import com.didispace.test.dao.mapping.TestCaseRecordMapper;
import com.didispace.test.tcase.infs.UserAddRsp;
import com.didispace.test.util.MatchResultMethon;
import com.didispace.test.util.MethodContext;
import com.didispace.web.User;

@RestController
public class TestContorl 
{
	private static TestDataManager tdm=null;
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private TestCaseRecordMapper testCaseRecordMapper;
	static
	{
		if(TestContorl.tdm == null)
		{
			tdm = new TestDataManager(); 
		}
	}
	
	@RequestMapping("/interfaces")
    public String interfaces(@RequestParam("intfacename") String name,@RequestParam("caseid") String caseid) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException 
	{
		Map<String,MatchResultMethon> ifsMap = TestManageContorl.getInterfacemethod();
		MatchResultMethon curmed = ifsMap.get(name);
		MethodContext mct = curmed.getMatchMethodContext(caseid);
		String restr =TestContorl.tdm.getReqdata(caseid,name);
		Object ob = objectMapper.readValue(restr, curmed.getParamerClass());
		//System.out.println("caseid="+caseid);
		String retstr = mct.invokeMethod(null, new Object[]{ob});
		TestContorl.tdm.setRetdata(caseid, retstr);
        return retstr;
    }
	
	
	@RequestMapping("/resultCompare")
    public String resultCompare(@RequestParam("intfacename") String name,@RequestParam("caseid") String caseid) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException 
	{
		ArrayList<Object> al = new ArrayList<Object>();
		Map<String,MatchResultMethon> ifsMap = TestManageContorl.getResultmethod();
		MatchResultMethon curmed = ifsMap.get(name);
		MethodContext mct = curmed.getMatchMethodContext(caseid);
		curmed = mct.getCurMRM();
		//获取请求数据
		String restr = TestContorl.tdm.getReqdata(caseid,name);
		//接口返回数据
		String sponsestr = TestContorl.tdm.getRetdata(caseid,name);
		//获取预期结果数据
		String yqresult = TestContorl.tdm.getResultdata(caseid,name);
		if(curmed.getParamerClass()!=Class.class)
		{
//			System.out.println("yqresult="+yqresult);
//			System.out.println("caseid="+caseid);
//			System.out.println("class="+curmed.getParamerClass());
		    Object ob = objectMapper.readValue(yqresult, curmed.getParamerClass());
		    al.add(ob);
		}
		else
			al.add(yqresult);
		if(curmed.reqcls!=null)
		{
//			System.out.println("restr="+restr);
//			System.out.println("caseid="+caseid);
//			System.out.println("class="+curmed.reqcls);
		    Object obs = objectMapper.readValue(restr, curmed.reqcls);
		    al.add(obs);
		}
		else
			al.add(restr);
		String retstr = mct.invokeMethod(null, new Object[]{sponsestr,al.get(1),al.get(0)});
        return retstr;
    }
	
	@RequestMapping(value = "/prop/testplandetail", method = { RequestMethod.GET })
	 public String resultComparetest(@RequestParam("testPlanName") String planname) 
	 {
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"total\":17,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"total\":10,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/testltj/signUpNonOpenActivities\",\"interfaceclass\":\"errorClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		TestCaseRecord tcr = this.testCaseRecordMapper.selectByPrimaryKey(1);
		System.out.println("tcr.getClassname=" + tcr.getClassname());
		return jsonrst;
	 }
	
	@RequestMapping(value = "/prop/testapp", method = { RequestMethod.GET })
	 public TestCaseRecord resultComparetestff(@RequestParam("testPlanName") String planname) 
	 {
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"total\":17,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"total\":10,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/testltj/signUpNonOpenActivities\",\"interfaceclass\":\"errorClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		TestCaseRecord tcr = this.testCaseRecordMapper.selectByPrimaryKey(1);
		System.out.println("tcr.getClassname=" + tcr.getClassname());
		return tcr;
	 }
	
	@RequestMapping(value = "/prop/testappmap", method = { RequestMethod.GET })
	 public HashMap<String,Object> resultComparetestMap(@RequestParam("planid") Integer planid) 
	 {
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"total\":17,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"total\":10,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/testltj/signUpNonOpenActivities\",\"interfaceclass\":\"errorClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		List<Map<String, Object>> rst =  this.testCaseRecordMapper.getTestPlanRstHashMap(planid);
		for(Map<String, Object> map : rst)
		{
			String interfacename = (String) map.get("interfaceName");
			TestCaseRecord tcr = new TestCaseRecord();
			tcr.setPlanId(planid);
			tcr.setInterfacename(interfacename);
			List<TestCaseRecord> caselist = this.testCaseRecordMapper.getTestCasesByPlanIdOrInterface(tcr);
			map.put("result", caselist);
		}
		HashMap<String,Object> retmap = new HashMap<String,Object>();
		retmap.put("code", "000000");
		retmap.put("testrst", rst);
//		System.out.println("tcr.getClassname=" + tcr.getClassname());
		return retmap;
	 }
	
	@RequestMapping(value = "/prop/testplanlist", method = { RequestMethod.GET })
	 public HashMap<String,Object> resultTestPlanList(@RequestParam("planid") Integer planid) 
	 {
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"total\":17,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"total\":10,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":10,\"fail\":3,\"error\":4,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":2,\"success\":4,\"fail\":3,\"error\":3,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//String jsonrst = "{\"retcode\":\"00000\",\"testrst\":[{\"interfaceName\":\"/activities-service/raffleResult/luckDraw-dzp\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":1,\"fail\":3,\"error\":0,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"failCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/raffleResult/signUpNonOpenActivities\",\"interfaceclass\":\"passClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]},{\"interfaceName\":\"/activities-service/testltj/signUpNonOpenActivities\",\"interfaceclass\":\"errorClass\",\"total\":4,\"success\":2,\"fail\":1,\"error\":1,\"result\":[{\"caseid\":\"wheel_add_1\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"0\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_2\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_3\",\"trclass\":\"hiddenRow\",\"caseclass\":\"none\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"2\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"},{\"caseid\":\"wheel_add_4\",\"trclass\":\"none\",\"caseclass\":\"errorCase\",\"testPoint\":\"大转盘抽奖-发货类型实物\",\"resultSign\":\"1\",\"errinfo\":\"ft1.1: Traceback (most recent call last):\"}]}]}";
		//List<Map<String, Object>> rst =  this.testCaseRecordMapper.getTestPlanRstHashMap(1);
		ArrayList<TestPlan> rst = new  ArrayList<TestPlan>();
		TestPlan tp = new TestPlan();
		tp.setPlantime("2018-01-03 22:03:11");
		tp.setId(1);
		rst.add(tp);
		TestPlan tpp = new TestPlan();
		tpp.setPlantime("2018-01-03 21:03:11");
		tpp.setId(2);
		rst.add(tpp);
//		for(Map<String, Object> map : rst)
//		{
//			String interfacename = (String) map.get("interfaceName");
//			TestCaseRecord tcr = new TestCaseRecord();
//			tcr.setPlanId(planid);
//			tcr.setInterfacename(interfacename);
//			List<TestCaseRecord> caselist = this.testCaseRecordMapper.getTestCasesByPlanIdOrInterface(tcr);
//			map.put("result", caselist);
//		}
		HashMap<String,Object> retmap = new HashMap<String,Object>();
		retmap.put("code", "000000");
		retmap.put("listplan", rst);
//		System.out.println("tcr.getClassname=" + tcr.getClassname());
		return retmap;
	 }
	
	@RequestMapping(value = "/prop/users", method = { RequestMethod.GET })
	 public String resultComparetest(@RequestParam("uuid") String name,@RequestParam("moblieNo") String caseid) 
	 {
		return "litaojun";
	 }
	
	@RequestMapping(value = "/prop/users", method = { RequestMethod.POST })
	public String resultComparetest(@RequestBody HashMap<String,UserPropInfo>  user) 
	 {
		System.out.println("user.getUuid====="+user.get("data").getUuid());
		return "litaojun";
		
	 }
	public static void main(String[] args)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Object ob = objectMapper.readValue("{\"retcode\":1,\"errstr\":\"sssssssssssssss\"}", UserAddRsp.class);
			UserAddRsp fob = objectMapper.readValue("{'retcode':1,'errstr':'sssssssssssssss'}", UserAddRsp.class);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
