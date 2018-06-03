package com.lfy.SingletonMode;

/**
 * @author lfy
 * @since 2018/06/03
 * @see  ����ģʽ����2-5��ʵ�ַ�ʽ�⣬������ͨ��:ö������ ��̬�ڲ�����ʵ�ֵ���ģʽ,��������ѧϰ
 * 
 * */
public class TestWithMultiThreading extends Thread {

	@Override
	public void run(){
		try{
			//����SingletonMode2.java�ڶ��߳������̲߳���ȫ��
//			System.out.println(SingletonMode2.getInstance());
			//����SingletonMode3.java�ڶ��߳������̰߳�ȫ��
//			System.out.println(SingletonMode3.getInstance());
			//����SingletonMode4.java�ڶ��߳������̰߳�ȫ��
//			System.out.println(SingletonMode4.getInstance());
			//����SingletonMode5.java�ڶ��߳������̰߳�ȫ�ģ������������SingletonMode4.java���߳��޸��ڴ����ȡ��һ������
			System.out.println(SingletonMode5.getInstance());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
       
		TestWithMultiThreading t1=new TestWithMultiThreading();
		t1.start();
		
		TestWithMultiThreading t2=new TestWithMultiThreading();
		t2.start();
	}

}
