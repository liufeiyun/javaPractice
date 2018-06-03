package com.lfy.ThreadsSynchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSellSolution4 implements Runnable {

    private int num = 50;
    //����һ��������
    Lock l = new ReentrantLock();
    
	@Override
	public void run() {

        for(int i = 0 ; i < 50 ;i ++){
            //��ȡ��
            l.lock();
            try {
                if(num > 0){
	                Thread.sleep(10);
	                System.out.println(Thread.currentThread().getName()+"����һ��Ʊ��ʣ��"+(--num)+"��");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                //�ͷ���
                l.unlock();
            }
        }
	}

}
