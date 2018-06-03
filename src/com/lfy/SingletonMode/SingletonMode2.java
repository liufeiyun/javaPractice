package com.lfy.SingletonMode;

/**
 * 2、单例模式之懒汉模式（线程不安全）
 * @author lfy
 * @since 2018/06/03
 * @see   这方式是线程不安全的，测试看TestWithMultiThreading.java中的测试代码
 * */
public class SingletonMode2 {
	
	//构造器私有化
    private SingletonMode2(){
         
    }
    
    //在类的内部自己创建实例
    private static SingletonMode2 singleton = null;
 
    //提供get 方法以供外界获取单例
    public static SingletonMode2 getInstance(){
    	//在这里就出现问题了，假设A线程比B线程稍早到达
        if(singleton == null){
            singleton = new SingletonMode2();
        }
        return singleton;
    }
}