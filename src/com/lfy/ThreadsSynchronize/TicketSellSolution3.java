package com.lfy.ThreadsSynchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、使用锁机制
 * 语法：lock(),unlock()
*/
public class TicketSellSolution3 extends Thread{

	private static int num = 50;
	
	//创建一个锁对象
    Lock l = new ReentrantLock();
    
    public TicketSellSolution3(String string) {
        super(string);
    }
    
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ;i ++){
        	    l.lock();
                try {
                	if(num > 0){
                	  Thread.sleep(10);
                	  System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+(--num)+"张");
                	}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                	l.unlock();
                }
        }
    }
}
