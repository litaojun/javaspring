package com.didispace.thread.sysn1;
public class ThreadDemo3 {
//    public static void main(String[] args){
//        Ticket t =new Ticket();
//        Thread t1 = new Thread(t,"窗口一");
//        Thread t2 = new Thread(t,"窗口二");
//        Thread t3 = new Thread(t,"窗口三");
//        Thread t4 = new Thread(t,"窗口四");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//    }
}
class Ticket implements Runnable{
    private int ticket =4000;
    @Override
	public void run(){
        while(true){
            synchronized (new Object()) {
                try {
                	Ta t=new Ta();
                	Thread t1 = new Thread(t,Thread.currentThread().getName());
                	t1.join();
                	t1.start();
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(ticket<=0)
                    break;
                System.out.println(Thread.currentThread().getName()+"---卖出"+ticket--);
            }
        }
    }
  class Ta implements Runnable{
	  @Override
	public void run(){
		  for(int i=0;i<5;i++)
		  {
			  System.out.println(Thread.currentThread().getName()+"xx"+i);
		  }
	  }
  }
  
}