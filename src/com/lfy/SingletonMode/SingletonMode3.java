package com.lfy.SingletonMode;

/**
 * 3������ģʽ֮����ģʽ���̰߳�ȫ��
 * @author lfy
 * @since 2018/06/03
 * @see   �ⷽʽ���̰߳�ȫ�ģ����Կ�TestWithMultiThreading.java
 * */
public class SingletonMode3 {

	//������˽�л�
    private SingletonMode3(){
         
    }
    
    //������ڲ��Լ�����ʵ��
    private static SingletonMode3 singleton = null;
 
    //�ṩget �����Թ�����ȡ����
    public static SingletonMode3 getInstance() throws Exception{
    	
    	synchronized (SingletonMode3.class){
	        if(singleton == null){
	            singleton = new SingletonMode3();
	        }
    	}
        return singleton;
    }
}
