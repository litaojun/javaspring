package com.didispace.thread.sysn5;

/*
 *线程等待唤醒机制
 *等待和唤醒必须是同一把锁 
 */
public class ThreadDemo3 {
    private static boolean flags =false;
    public static void main(String[] args){
        class Person{
            public String name;
            private String gender;
            public void set(String name,String gender){
                this.name =name;
                this.gender =gender;
            }
            public void get(){
                System.out.println(this.name+"...."+this.gender);
            }
        }
        final Person p =new Person();
        new Thread(new Runnable(){
            @Override
			public void run(){
                int x=0;
                while(true){
                    synchronized (p) {
                        if(flags)
                            try {
                                p.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            };
                        if(x==0){
                            p.set("张三", "男");
                        }else{
                            p.set("lili", "nv");
                        }
                        x=(x+1)%2;
                        flags =true;
                        p.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
			public void run(){
                while(true){
                    synchronized (p) {
                        if(!flags)
                            try {
                                p.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            };
                        p.get();
                        flags =false;
                        p.notifyAll();
                        }
                }
            }
        }).start();
    }
}