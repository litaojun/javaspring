package com.didispace.web;

import java.io.Serializable;  

/** 
 * User�������ʵ��serializable�ӿڣ���Ϊ����session�е����ݱ����ǿ����л��ġ� 
 * �������ִ��� setAttribute: Non-serializable attribute... 
 * @author Administrator 
 * @version 2011-10-6 
 */  
public class User implements Serializable {  
      
    private static final long serialVersionUID = 1L;  
    private String username;  
    private String password;  
    private int age;  
    private String sex;  
    private String birthday;  
    
  
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
  
    public int getAge(){  
        return age;  
    }  
  
    public void setAge(int age){  
        this.age = age;  
    }  
  
    public String getSex() {  
        return sex;  
    }  
  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
  
    public String getBirthday() {  
        return birthday;  
    }  
  
    public void setBirthday(String birthday) {  
        this.birthday = birthday;  
        
    }  
  
    @Override  
    public String toString() {  
        // TODO Auto-generated method stub  
        return this.username +"#"+ this.password +"#"+ this.age +"#"+ this.sex +"#"+ this.birthday;  
    }  
  
}  
