package com.lfy.ThreadsSynchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1��ʹ��������
 * �﷨��lock(),unlock()
*/
public class TicketSellSolution3 extends Thread{

	private static int num = 50;
	
	//����һ��������
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
                	  System.out.println(Thread.currentThread().getName()+"����һ��Ʊ��ʣ��"+(--num)+"��");
                	}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                	l.unlock();
                }
        }
    }
}
