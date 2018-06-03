package com.lfy.ThreadsSynchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSellSolution4 implements Runnable {

    private int num = 50;
    //创建一个锁对象
    Lock l = new ReentrantLock();
    
	@Override
	public void run() {

        for(int i = 0 ; i < 50 ;i ++){
            //获取锁
            l.lock();
            try {
                if(num > 0){
	                Thread.sleep(10);
	                System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+(--num)+"张");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                //释放锁
                l.unlock();
            }
        }
	}

}
