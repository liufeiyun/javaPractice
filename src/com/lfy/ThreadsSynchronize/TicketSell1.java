package com.lfy.ThreadsSynchronize;

/**
 * ����취�����������ǲ���ͬʱ�ó����������ϵ��߳̽��뵽 if(num>0)�Ĵ������
 * 1��ʹ�� ͬ�������

   2��ʹ�� ͬ������

   3��ʹ�� ������
*/
public class TicketSell1 extends Thread{

	//����һ���� 50 ��Ʊ��ע������Ϊ static,��ʾ�������ڹ���
    private static int num = 50;
     
    //���ø��๹�췽�������߳�����
    public TicketSell1(String string) {
        super(string);
    }
    
    @Override
    public void run() {
        //Ʊ�� 50 ������
        for(int i = 0 ; i < 50 ;i ++){
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
