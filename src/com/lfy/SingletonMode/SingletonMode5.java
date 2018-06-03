package com.lfy.SingletonMode;

/**
 * 3、单例模式之最终版
 * @author lfy
 * @since 2018/06/03
 * @see   我们知道编译就是将源代码翻译成机器码的过程，而Java虚拟机的目标代码不是本地机器码，而是虚拟机代码。
 *        编译原理里面有个过程是编译优化，就是指在不改变原来语义的情况下，通过调整语句的顺序，来让程序运行得更快，这个过程称为 reorder。

　　JVM 只是一个标准，它并没有规定有关编译器优化的内容，也就是说，JVM可以自由的实现编译器优化。

　　那么我们来再来考虑一下，创建一个变量需要哪些步骤？

　　　　①、申请一块内存，调用构造方法进行初始化

　　　　②、分配一个指针指向该内存

　　而这两步谁先谁后呢？也就是存在这样一种情况：先开辟一块内存，然后分配一个指针指向该内存，最后调用构造方法进行初始化。

　　那么针对单例模式的设计，就会存在这样一个问题：线程 A 开始创建 Singleton 的实例，此时线程 B已经调用了 getInstance的（）方法，首先判断 instance 是否为 null。

        而我们SingletonMode4说的那种模型， A 已经把 instance 指向了那块内存，只是还没来得及调用构造方法进行初始化，因此 B 检测到 instance 不为 null，于是直接把  instance 返回了。
        
        那么问题出现了：尽管 instance 不为 null，但是 A 并没有构造完成，就想一套房子已经给了你钥匙，但是里面还没有装修，你并不能住进去（或者说你还不能使用这个实例，比如当前的instance句柄指向的内存区）。
        
       即如果线程B比线程A在实例化完成前发起了使用，这是存在风险的。

　　解决方案：使用 volatile 关键字修饰 instance

　　我们知道在当前的Java内存模型下，线程可以把变量保存在本地内存（比如机器的寄存器）中，而不是直接在主存中进行读写。这就可能造成一个线程在主存中修改了一个变量的值，而另外一个线程还继续使用它在寄存器

       中的变量值的拷贝，造成数据的不一致。volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，
       
       两个不同的线程总是看到某个成员变量的同一个值。
       
       注意事项：volatile  关键字是 JDK1.5 才有的，也就是 JDK1.5 之前是不能这样用的。
       
 * */
public class SingletonMode5 {

	//构造器私有化
    private SingletonMode5(){
         
    }
    
    //在类的内部自己创建实例,并且使用volatile
    private static volatile SingletonMode5 singleton = null;
 
    public static SingletonMode5 getInstance() throws Exception{
    	//--双重校验锁
    	if(singleton == null){
	    	synchronized (SingletonMode5.class){
		        if(singleton == null){
		            singleton = new SingletonMode5();
		        }
	    	}
    	}
        return singleton;
    }
}
