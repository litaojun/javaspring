package com.didispace.thread.sysn8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//http://www.cnblogs.com/anbylau2130/archive/2013/04/17/3025347.html
//JDK1.5中提供了多线程升级解决方案，
//、将同步Synchronized替换成现实lock操作
//将object中的wait，notify，notifyall，替换成Condition对象，
//该对象可以Lock锁，进行获取
//在该实例中，实现了本方只唤醒对方操作
// 
//一个lock对应多个Condition
class Resourc
{
    private  String name;
    private  String sex;
    private  boolean flag=false;
 
 
    public  Lock lock=new ReentrantLock();
    
    private  Condition condition_con=lock.newCondition();
    private  Condition condition_pro=lock.newCondition();
   
   void set(String name,String sex)
   {
	   
     try{
     lock.lock();
        while(flag==false)
        	condition_pro.await();
        this.name=name;
        this.sex=sex;
        this.flag=true; 
    }
    catch(Exception e)  
    {
     lock.unlock();
    }
     condition_con.signal();   //唤醒r对象所在的线程
      
   }
    void out() 
    {
      lock.lock();
             while(!flag)
				try {
					condition_con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             System.out.println(this.name+"..."+this.sex);
             this.flag=false; 
      lock.unlock();  
      condition_pro.signal();    //唤醒r对象所在的线程
    }
}
