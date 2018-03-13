package com.didispace.thread.sysn2;

public class ThreadDemo3 {
    public static void main(String[] args){
        Ticket t =new Ticket();
        Thread t1 = new Thread(t,"窗口一");
        Thread t2 = new Thread(t,"窗口二");
        Thread t3 = new Thread(t,"窗口三");
        Thread t4 = new Thread(t,"窗口四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Ticket implements Runnable{
    private int ticket = 4000;
    public synchronized void  saleTicket() throws InterruptedException{
        if(ticket>0)
        {
            System.out.println(Thread.currentThread().getName()+"卖出了"+ticket--);
            this.notifyAll();
        }

    }
    @Override
	public void run(){
        while(true){
            try {
				saleTicket();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(this.ticket==0)
            {
            	break;
            }
        }
    }
}
