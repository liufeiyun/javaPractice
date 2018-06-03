package com.lfy.ThreadsProdecerAndConsumer;

public class TestMultiThreadWithProducerAndConsumer {

	public static void main(String[] args) {

		/**
		 * 1、第一种实现会有两种现象：
		 *   a)人名与年龄搭配不按预期搭配
		 *   b)出现重复数据，主要是消费者没有生产者的频率高，即跟不上节奏
		 * 总结得出：
		 *   解决问题a：生产者生产name和age必须要是一个整体一起完成，即同步。生产的中间不能让消费者来消费即可。便不会产生错乱的数据。
		 *           我们可以选择在共享资源Person中的push()、pop()使用关键字synchronized修饰，即同步方法。
		 *   解决问题b:生产者生产一次数据了，生产者线程暂停，等待消费者消费；消费者消费完了，消费者线程暂停，等待生产者生产数据，这样交替进行。
		 *   结合解决问题a的方式，这一个最终问题的解决见PersonAdvanced.java
		 * 2、关于解决问题b的一些知识学习：
		 *   介绍一个同步锁池的概念：
		 *     同步锁池：同步锁必须选择多个线程共同的资源对象(比如本例的Person或PersonAdvanced)，而一个线程获得锁的时候，别的线程都在同步锁池等待获取锁；
		 *            当那个线程释放同步锁了，其他线程便开始由CPU调度分配锁。
		 *     关于让线程等待和唤醒线程的方法，如下：（这是 Object 类中的方法）
		 *        返回值类型                       方法名                                                                                                                                说明
		 *         void        wait()                        导致当前线程等待，直到另一个线程调用该对象的notify()方法或notifyAll()方法。
		 *         void        wait(long timeout)            导致当前线程等待，直到另一个线程调用该对象的notify()方法或notifyAll()方法，或者指定的时间已过。（单位：毫秒）
		 *         void        wait(long timeout,int nanos)  导致当前线程等待，直到另一个线程调用该对象的notify()方法或notifyAll()方法，或者某些其他线程中断当前线程，或一定量的实时时间。（单位：毫秒、纳秒）
		 *         void        notify()                      唤醒正在等待对象监视器的单个线程。
		 *         void        notifyAll()                   唤醒正在等待对象监视器的所有线程。
		 *     总结理解：
		 *          wait():执行该方法的线程对象，释放同步锁，JVM会把该线程放到等待池中，等待其他线程唤醒该线程

					notify():执行该方法的线程唤醒在等待池中等待的任意一个线程，把线程转到锁池中等待（注意锁池和等待池的区别）
					
					notifyAll():执行该方法的线程唤醒在等待池中等待的所有线程，把线程转到锁池中等待。
					
					注意：上述方法只能被同步监听锁对象来调用，这也是为啥wait() 和 notify()方法都在 Object 对象中，因为同步监听锁可以是任意对象，
					         只不过必须是需要同步线程的共同对象即可，否则别的对象调用会报错：java.lang.IllegalMonitorStateException
					
					假设 A 线程和 B 线程同时操作一个 X 对象，A，B 线程可以通过 X 对象的 wait() 和 notify() 方法来进行通信，流程如下：
					
					①、当线程 A 执行 X 对象的同步方法时，A 线程持有 X 对象的 锁，B线程在 X 对象的锁池中等待
					
					②、A线程在同步方法中执行 X.wait() 方法时，A线程释放 X 对象的锁，进入 X 对象的等待池中
					
					③、在 X 对象的锁池中等待锁的 B 线程获得 X 对象的锁，执行 X 的另一个同步方法
					
					④、B 线程在同步方法中执行 X.notify() 方法，JVM 把 A 线程从等待池中移动到 X 对象的锁池中，等待获取锁
					
					⑤、B 线程执行完同步方法，释放锁，等待获取锁的 A 线程获得锁，继续执行同步方法
		   3、死锁:

				①、多线程通信的时候，很容易造成死锁，死锁无法解决，只能避免
				
				②、当 A 线程等待由 B 线程持有的锁，而 B 线程正在等待由 A 线程持有的锁时发生死锁现象（比如A拿着铅笔，B拿着圆珠笔，A说你先给我圆珠笔，我就把铅笔给你，
				
				       而B说你先给我铅笔，我就把圆珠笔给你，这就造成了死锁，A和B永远不能进行交换）
				
				③、JVM 既不检测也不避免这种现象，所以程序员必须保证不能出现这样的情况
				
		   4、Thread 类中容易造成死锁的方法（这两个方法都已经过时了，不建议使用）：
				
				suspend():使正在运行的线程放弃 CPU，暂停运行（不释放锁）
				
				resume():使暂停的线程恢复运行
				
				情景：A 线程获得对象锁，正在执行一个同步方法，如果 B线程调用 A 线程的 suspend() 方法，此时A 暂停运行，放弃 CPU 资源，但是不放弃同步锁，那么B也不能获得锁，
				
				    A又暂停，那么便造成死锁。
				
		   5、解决死锁法则：当多个线程需要访问 共同的资源A,B，C时，必须保证每一个线程按照一定的顺序去访问，比如都先访问A，然后B，最后C。就像我们这里的生产者---消费者模型，
		        
		                                            制定了必须生产者先生产一个对象，然后消费者去消费，消费完毕，生产者才能在开始生产，然后消费者在消费。这样的顺序便不会造成死锁。
		 *   */
		//1、第一种仅解决问题a的方式
//		Person p=new Person();
//		Thread pThread=new Thread(new Producer(p));
//		Thread cThread=new Thread(new Consumer(p));
//		pThread.start();
//		cThread.start();
		//2、第二种解决问题a、b的合并的方式
		PersonAdvanced pAdvanced=new PersonAdvanced(); 
		Thread pThread=new Thread(new ProducerAdvanced(pAdvanced));
		Thread cThread=new Thread(new ConsumerAdvanced(pAdvanced));
		pThread.start();
		cThread.start();
	}

}
