package com.lfy.ThreadsProdecerAndConsumer;

/**
 * @see 创建生产者线程，并在 run() 方法中生产50个对象,不考虑消费者有没有取走前一次的生产
 * */
public class Producer implements Runnable {

	//共享资源对象
    Person p = null;
    
    public Producer(Person p){
        this.p = p;
    }
    
    @Override
    public void run() {
        //生产对象
        for(int i = 0 ; i < 50 ; i++){
            //如果是偶数，那么生产对象 Tom--11;如果是奇数，则生产对象 Marry--21
            if(i%2==0){
                p.push("Tom", 11);
            }else{
                p.push("Marry", 21);
            }
        }
    }
}
