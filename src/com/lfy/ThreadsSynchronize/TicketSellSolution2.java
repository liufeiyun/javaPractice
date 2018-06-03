package com.lfy.ThreadsSynchronize;

/**
 * 1��ʹ��ͬ������
 * �﷨������  synchronized  �ؼ������η���
 
        ע�⣺����ֱ���� synchronized ������ run() ��������Ϊ�������������ô�ͻ����ǵ�һ���߳̽������У�������߳�ִ�������в���������������Ʊ�˲Ż������
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
            System.out.println(Thread.currentThread().getName()+"����һ��Ʊ��ʣ��"+(--num)+"��");
        }
    }
}
