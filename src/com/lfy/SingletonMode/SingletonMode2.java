package com.lfy.SingletonMode;

/**
 * 2������ģʽ֮����ģʽ���̲߳���ȫ��
 * @author lfy
 * @since 2018/06/03
 * @see   �ⷽʽ���̲߳���ȫ�ģ����Կ�TestWithMultiThreading.java�еĲ��Դ���
 * */
public class SingletonMode2 {
	
	//������˽�л�
    private SingletonMode2(){
         
    }
    
    //������ڲ��Լ�����ʵ��
    private static SingletonMode2 singleton = null;
 
    //�ṩget �����Թ�����ȡ����
    public static SingletonMode2 getInstance(){
    	//������ͳ��������ˣ�����A�̱߳�B�߳����絽��
        if(singleton == null){
            singleton = new SingletonMode2();
        }
        return singleton;
    }
}