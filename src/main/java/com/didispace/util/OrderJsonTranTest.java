package com.didispace.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.didispace.web.User;

public class OrderJsonTranTest {
	private Logger log = Logger.getLogger(EntryOrJsonJacksonControoler.class);
	private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    public OrderJsonTranTest()
    {
    	objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public String Entry2Json() throws JsonGenerationException, JsonMappingException, IOException{
		String retstr = null;
		OrderImpl odl = new OrderImpl();
		User user = new User();
		user.setUsername("wy");
		user.setPassword("321");
		user.setAge(23);
		user.setSex("man");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ssd hh:mm:ss").format(new Date()));
		odl.setOdrid("xxx0001");
		odl.setSarlay(999);
		odl.setUser(user);
		log.info("==============Java Bean >>> JSON Object==================");
		retstr = objectMapper.writeValueAsString(odl);
		return retstr;	
	}
	 /** 
     * 5、将json字符串转换成JavaBean对象 
     *    objectMapper.readValue() 
     *    第一个参数就是解析的JSON字符串，第二个参数是即将将这个JSON解析成Java对象的类型 
     */  
    public OrderImpl json2Entry(String json){  
    	OrderImpl oll =null;
        try {  
            log.info("==============JSON Object String >>> Java Bean ==================");  
            oll = objectMapper.readValue(json, OrderImpl.class);  
            
            log.info(oll);  
              
        } catch (JsonParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (JsonMappingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return oll;
    }  
    
    
    public String list2Json() throws JsonGenerationException, JsonMappingException, IOException{
		
    	String retstr = null;
		OrderImplList odl = new OrderImplList();
		ArrayList<User> userList = new ArrayList<User>();
		for(int i=0;i<3;i++){
			User user = new User();
			user.setUsername("wy"+i);
			user.setPassword("321"+i);
			user.setAge(23+i);
			user.setSex("man"+i);
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd hh:mm:ssd hh:mm:ss").format(new Date())+" "+i);
			userList.add(user);
		}
		log.info("==============Java List >>> JSON Object==================");
		odl.setUserlist(userList);
		odl.setOdrid("xxx0002");
		odl.setSarlay(9994);
		retstr = this.objectMapper.writeValueAsString(odl);
		return retstr;
	}
    
    
    public OrderImplList json2EntryList(String json){  
    	OrderImplList oll =null;
        try {  
            log.info("==============JSON Object String >>> Java Bean ==================");  
            oll = objectMapper.readValue(json, OrderImplList.class);  
            
            log.info(oll);  
              
        } catch (JsonParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (JsonMappingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return oll;
    }  
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException
	{
		OrderJsonTranTest ojtt = new OrderJsonTranTest();
//		String retstr = ojtt.Entry2Json();
//		System.out.println("retstr="+retstr);
//		OrderImpl oll =ojtt.json2Entry(retstr);
//		System.out.println("oll="+oll.getOdrid()+"-------"+oll.getUser().getSex());
		String retstr = ojtt.list2Json();
		System.out.println("retstr="+retstr);
		OrderImplList oll =ojtt.json2EntryList(retstr);
		System.out.println("oll="+oll.getOdrid()+"-------"+oll.getUserlist().get(0).getBirthday());
	}
}
