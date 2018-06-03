package com.lfy.SingletonMode;

/**
 * 3、单例模式之懒汉模式（线程安全）--双重校验锁
 * @author lfy
 * @since 2018/06/03
 * @see   这方式是线程安全的，测试看TestWithMultiThreading.java。<br>
 *        引入情景：在SingletonMode3的例子我们可以看到，synchronized 其实将方法内部的所有语句都已经包括了，
 *        每一个进来的线程都要单独进入同步代码块，判断实例是否存在，这就造成了性能的浪费。那么我们可以想到，其实在第一次已经创建了实例的情况下，
 *        后面再获取实例的时候，可不可以不进入这个同步代码块？
 * */
public class SingletonMode4 {

	//构造器私有化
    private SingletonMode4(){
         
    }
    
    //在类的内部自己创建实例
    private static SingletonMode4 singleton = null;
 
    public static SingletonMode4 getInstance() throws Exception{
    	//--双重校验锁
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
