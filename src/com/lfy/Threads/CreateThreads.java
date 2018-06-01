package com.lfy.Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lfy
 * @since 2018/06/01
 * @description 3种主要的创建线程的方式，
 *              其中涉及到内部类的使用方法
 * */
public class CreateThreads {

	public static void main(String[] args) {
    
		for(int i = 0 ; i < 10 ; i++){
            System.out.println("Main thread"+i);
            if(i==5){
            	//1、
//            	FirstTypeCreateThread th1 = new CreateThreads().new FirstTypeCreateThread();
//                th1.start();
                //2、
//                Thread th2 = new Thread(new CreateThreads().new SecondTypeCreateThread());
//                th2.start();
                //3、
            	ThirdTypeCreateThread ctt = new CreateThreads().new ThirdTypeCreateThread();  
                FutureTask<Integer> ft = new FutureTask<>(ctt);
                new Thread(ft,"有返回值的线程").start();
                try {
					System.out.println("子线程的返回值："+ft.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
            }
        }
		System.exit(0);
	}

	//1、first type by extends Thread
	class FirstTypeCreateThread extends Thread{
		
		@Override
		public void run(){
			for(int i=0;i<10;i++){
				System.out.println("FirstTypeCreateThread");
			}
		}
	}
	
	//2、second type by implements Runnable
	class SecondTypeCreateThread implements Runnable{
		
		@Override
		public void run(){
			for(int i=0;i<10;i++){
				System.out.println("SecondTypeCreateThread");
			}
		}
	}
	
	//3、third type by Callable and Future
    class ThirdTypeCreateThread implements Callable<Integer>{
		
    	@Override  
        public Integer call() throws Exception  
        {  
    		int i = 0;
            for(;i<10;i++)  
            {  
                System.out.println(Thread.currentThread().getName()+" "+i);  
            }  
            return i;  
        } 
	}
}
