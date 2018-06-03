package com.lfy.SingletonMode;

/**
 * 3������ģʽ֮����ģʽ���̰߳�ȫ��--˫��У����
 * @author lfy
 * @since 2018/06/03
 * @see   �ⷽʽ���̰߳�ȫ�ģ����Կ�TestWithMultiThreading.java��<br>
 *        �����龰����SingletonMode3���������ǿ��Կ�����synchronized ��ʵ�������ڲ���������䶼�Ѿ������ˣ�
 *        ÿһ���������̶߳�Ҫ��������ͬ������飬�ж�ʵ���Ƿ���ڣ������������ܵ��˷ѡ���ô���ǿ����뵽����ʵ�ڵ�һ���Ѿ�������ʵ��������£�
 *        �����ٻ�ȡʵ����ʱ�򣬿ɲ����Բ��������ͬ������飿
 * */
public class SingletonMode4 {

	//������˽�л�
    private SingletonMode4(){
         
    }
    
    //������ڲ��Լ�����ʵ��
    private static SingletonMode4 singleton = null;
 
    public static SingletonMode4 getInstance() throws Exception{
    	//--˫��У����
    	if(singleton == null){
	    	synchronized (SingletonMode4.class){
		        if(singleton == null){
		            singleton = new SingletonMode4();
		        }
	    	}
    	}
        return singleton;
    }
}
