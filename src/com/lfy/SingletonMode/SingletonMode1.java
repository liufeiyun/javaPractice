package com.lfy.SingletonMode;

/**
 * 1、什么是单例模式<br>
 * 采取一定的办法保证在整个软件系统中，单例模式确保对于某个类只能存在一个实例。有如下三个特点：<br>

　　①、单例类只能有一个实例<br>

　　②、单例类必须自己创建自己的实例<br>

　　③、单例类必须提供外界获取这个实例的方法<br>

   2、单例类的设计思想<br>
   ①、外界不能创建这个类的实例，那么必须将构造器私有化。<br>
   
   public class Singleton {
      //构造器私有化
      private Singleton(){
      
      }
   }
   
   ②、单例类必须自己创建自己的实例，不能允许在类的外部修改内部创建的实例，所以将这个实例用 private 声明。
   为了外界能访问到这个实例，我们还必须提供 get 方法得到这个实例。因为外界不能 new 这个类，所以我们必须用 static 来修饰字段和方法。<br>
    //在类的内部自己创建实例
    private static Singleton singleton = new Singleton();
 
    //提供get 方法以供外界获取单例
    public Singleton getInstance(){
        return singleton;
    }
*/
/**
 * 1、单例模式之饿汉模式
 * @author lfy
 * @since 2018/06/03
 * @see   这种模式避免了多线程的同步问题，不过在 类装载的时候就进行了实例化，有可能这个实例化过程很长，那么就会加大类装载的时间；
 *        有可能这个实例现阶段根本用不到，那么创建了这个实例，也会浪费内存。没有达到 lazy-loading 的效果。
 * */
public class SingletonMode1 {
	
	//构造器私有化
    private SingletonMode1(){
         
    }
    
    //在类的内部自己创建实例
    private static SingletonMode1 singleton = new SingletonMode1();
 
    //提供get 方法以供外界获取单例
    public static SingletonMode1 getInstance(){
        return singleton;
    }
    
    public static void main(String[] args) {
        SingletonMode1 s1 = SingletonMode1.getInstance();
        SingletonMode1 s2 = SingletonMode1.getInstance();
        System.out.println(s1.equals(s2)); //true
    }
}
