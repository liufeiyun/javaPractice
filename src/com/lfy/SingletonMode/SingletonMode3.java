package com.lfy.SingletonMode;

/**
 * 3、单例模式之懒汉模式（线程安全）
 * @author lfy
 * @since 2018/06/03
 * @see   这方式是线程安全的，测试看TestWithMultiThreading.java
 * */
public class SingletonMode3 {

	//构造器私有化
    private SingletonMode3(){
         
    }
    
    //在类的内部自己创建实例
    private static SingletonMode3 singleton = null;
 
    //提供get 方法以供外界获取单例
    public static SingletonMode3 getInstance() throws Exception{
    	
    	synchronized (SingletonMode3.class){
	        if(singleton == null){
	            singleton = new SingletonMode3();
	        }
    	}
        return singleton;
    }
}
