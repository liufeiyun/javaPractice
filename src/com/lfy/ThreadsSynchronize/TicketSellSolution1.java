package com.lfy.ThreadsSynchronize;

/**
 * 1��ʹ��ͬ�������
 * �﷨��
	synchronized (ͬ����) {
	    //��Ҫͬ�������Ĵ���         
	}
 
	ͬ������Ϊ�˱�֤ÿ���̶߳���������ִ��ԭ�Ӳ�����Java �߳�������ͬ�����ƣ�ͬ����Ҳ��ͬ����������ͬ������������������
	Java��������ʹ�õ��κζ��󶼿�����Ϊͬ���������󣬵���һ�����ǰѵ�ǰ�������ʵĹ�ͬ��Դ��Ϊͬ����������
	 
	ע�⣺ͬ����һ��Ҫ��֤��ȷ���ģ�����������߳��Ǳ仯�Ķ����κ�ʱ���������һ���߳��õ�ͬ������˭�õ���˭�������飬���������߳�ֻ�����������
*/
public class TicketSellSolution1 extends Thread{

    private static int num = 50;
     
    public TicketSellSolution1(String string) {
        super(string);
    }
    
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ;i ++){
        	//��������ʹ�õ�ǰ������ֽ��������Ϊͬ����
            synchronized (this.getClass()) {
	            if(num > 0){
	                try {
	                	Thread.sleep(10);//ģ����Ʊ��Ҫһ����ʱ��
	                } catch (InterruptedException e) {
	                    // ���ڸ���� run()����û���׳��κ��쳣�����ݼ̳е�ԭ�������׳����쳣���ܴ��ڸ��࣬ ����������Ҳ�����׳��쳣
	                    e.printStackTrace();
	                }
	                System.out.println(Thread.currentThread().getName()+"����һ��Ʊ��ʣ��"+(--num)+"��");
	            }
            }
        }
    }
}
