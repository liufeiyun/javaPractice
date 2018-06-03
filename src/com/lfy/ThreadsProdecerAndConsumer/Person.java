package com.lfy.ThreadsProdecerAndConsumer;

/**
 * 背景描述：通过java多线程学习，我们已经了解了多线程基本的知识
 *    1、概念的引入 
 *    2、进程、线程的创建
 *    3、线程的同步
 *    
 *    进一步的我们学习生产者和消费者模型：
 *       生产者Producer生产某个对象（共享资源），放在缓冲池中，然后消费者Consumer从缓冲池中取出这个对象。
 *       
 *       也就是生产者生产一个，消费者消耗一个。这样进行循环。
 *
 *    */
/**
 * @see  第一步：我们先创建共享资源的类 Person,它有两个方法，一个生产对象，一个消费对象。
 *       下一步创建生产者Producer线程类。
 * */
public class Person {

	private String name;
    private int age;
     
    /**
     * 生产数据
     * @param name
     * @param age
     */
    public synchronized void push(String name,int age){
        this.name = name;
        try {
        	/**
        	 * 这时候你发现：我们预期奇数搭配为Marry---21、偶数Tom--11，但因为线程不同步的问题，
        	 * 使生产者修改name、age的时间也出现了错位，消费者取的时候得到了2的2次方种结果可能。
        	 * 添加这段代码只是为了让结果更明显，当没有这段代码时，多线程的情况下在
        	 *    this.name = name;
        	 *    this.age = age;
        	 * 之间两行代码之间也是会存在这种情况的时候的。
        	 * */
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        this.age = age;
    }
    
    /**
     * 取数据，消费数据
     * @return
     */
    public synchronized void pop(){
    	
    	try {
    		/**
    		 * 添加这段代码与在生产数据中的添加原理相同
    		 * */
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(this.name+"---"+this.age);
    }
}
