package com.didispace.web;

import java.io.Serializable;  

/** 
 * User�������ʵ��serializable�ӿڣ���Ϊ����session�е����ݱ����ǿ����л��ġ� 
 * �������ִ��� setAttribute: Non-serializable attribute... 
 * @author Administrator 
 * @version 2011-10-6 
 */  
public class UserInfo implements Serializable {  
      
    private static final long serialVersionUID = 1L;  
    private String username;  
    private String password;  
    private String nickname;  
    private String imgurl;  
    
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  

    
  
    public String getNickname() {  
        return nickname;  
    }  
  
    public void setNickname(String nickname) {  
        this.nickname = nickname;  
    }  
  
    public String getImgurl() {  
        return imgurl;  
    }  
  
    public void setImgurl(String imgurl) {  
        this.imgurl = imgurl;  
        
    }  
  
//    @Override  
//    public String toString() {  
//        // TODO Auto-generated method stub  
//        return this.username +"#"+ this.password +"#"+ this.age +"#"+ this.sex +"#"+ this.birthday;  
//    }  
  
}  
