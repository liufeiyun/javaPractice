package com.lfy.ThreadsSynchronize;

/**
 * 1、使用同步方法
 * 语法：即用  synchronized  关键字修饰方法
 
        注意：不能直接用 synchronized 来修饰 run() 方法，因为如果这样做，那么就会总是第一个线程进入其中，而这个线程执行完所有操作，即卖完所有票了才会出来。
*/
public class TicketSellSolution2 extends Thread{

	private static int num = 50;
    
    public TicketSellSolution2(String string) {
        super(string);
    }
    
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ;i ++){
        	sell();
        }
    }
    
    private synchronized void sell() {
        if(num > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+(--num)+"张");
        }
    }
}
