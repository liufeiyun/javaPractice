package com.lfy.ThreadsSynchronize;

/**
 * 1、使用同步代码块
 * 语法：
	synchronized (同步锁) {
	    //需要同步操作的代码         
	}
 
	同步锁：为了保证每个线程都能正常的执行原子操作，Java 线程引进了同步机制；同步锁也叫同步监听对象、同步监听器、互斥锁；
	Java程序运行使用的任何对象都可以作为同步监听对象，但是一般我们把当前并发访问的共同资源作为同步监听对象
	 
	注意：同步锁一定要保证是确定的，不能相对于线程是变化的对象；任何时候，最多允许一个线程拿到同步锁，谁拿到锁谁进入代码块，而其他的线程只能在外面等着
*/
public class TicketSellSolution1 extends Thread{

    private static int num = 50;
     
    public TicketSellSolution1(String string) {
        super(string);
    }
    
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ;i ++){
        	//这里我们使用当前对象的字节码对象作为同步锁
            synchronized (this.getClass()) {
	            if(num > 0){
	                try {
	                	Thread.sleep(10);//模拟卖票需要一定的时间
	                } catch (InterruptedException e) {
	                    // 由于父类的 run()方法没有抛出任何异常，根据继承的原则，子类抛出的异常不能大于父类， 故我们这里也不能抛出异常
	                    e.printStackTrace();
	                }
	                System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+(--num)+"张");
	            }
            }
        }
    }
}
