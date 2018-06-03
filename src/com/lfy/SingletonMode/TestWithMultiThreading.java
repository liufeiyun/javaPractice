package com.lfy.SingletonMode;

/**
 * @author lfy
 * @since 2018/06/03
 * @see  单例模式除了2-5种实现方式外，还可以通过:枚举类型 或静态内部类来实现单例模式,留到后续学习
 * 
 * */
public class TestWithMultiThreading extends Thread {

	@Override
	public void run(){
		try{
			//测试SingletonMode2.java在多线程下是线程不安全的
//			System.out.println(SingletonMode2.getInstance());
			//测试SingletonMode3.java在多线程下是线程安全的
//			System.out.println(SingletonMode3.getInstance());
			//测试SingletonMode4.java在多线程下是线程安全的
//			System.out.println(SingletonMode4.getInstance());
			//测试SingletonMode5.java在多线程下是线程安全的，且完美解决了SingletonMode4.java多线程修改内存与读取不一致问题
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
