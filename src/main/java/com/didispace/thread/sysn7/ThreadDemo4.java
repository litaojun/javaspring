package com.didispace.thread.sysn7;
//64092222
//33972202
public class ThreadDemo4 {
    private static boolean flags =false;
//    public static void main(String[] args){
//        class Goods{
//            private String name;
//            private int num;
//            public synchronized void produce(String name){
//                while(flags)
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                this.name =name+"编号："+num++;
//                System.out.println(Thread.currentThread().getName()+"生产了...."+this.name);
//                flags =true;
//                notifyAll();
//            }
//            public synchronized void consume(){
//                while(!flags)
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                System.out.println(Thread.currentThread().getName()+"消费了******"+name);
//                flags =false;
//                notifyAll();
//            }
//
//        }
//        final Goods g =new Goods();
//        new Thread(new Runnable(){
//            @Override
//			public void run(){
//                while(true){
//                    g.produce("商品");
//                }
//            }
//        },"生产者一号").start();
//        new Thread(new Runnable(){
//            @Override
//			public void run(){
//                while(true){
//                    g.produce("商品");
//                }
//            }
//        },"生产者二号").start();
//        new Thread(new Runnable(){
//            @Override
//			public void run(){
//                while(true){
//                    g.consume();
//                }
//            }
//        },"消费者一号").start();
//        new Thread(new Runnable(){
//            @Override
//			public void run(){
//                while(true){
//                    g.consume();
//                }
//            }
//        },"消费者二号").start();
//    }
}
