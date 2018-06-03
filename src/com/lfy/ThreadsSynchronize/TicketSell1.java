package com.lfy.ThreadsSynchronize;

/**
 * 解决办法分析：即我们不能同时让超过两个以上的线程进入到 if(num>0)的代码块中
 * 1、使用 同步代码块

   2、使用 同步方法

   3、使用 锁机制
*/
public class TicketSell1 extends Thread{

	//定义一共有 50 张票，注意声明为 static,表示几个窗口共享
    private static int num = 50;
     
    //调用父类构造方法，给线程命名
    public TicketSell1(String string) {
        super(string);
    }
    
    @Override
    public void run() {
        //票分 50 次卖完
        for(int i = 0 ; i < 50 ;i ++){
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
