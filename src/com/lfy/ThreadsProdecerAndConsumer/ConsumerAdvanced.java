package com.lfy.ThreadsProdecerAndConsumer;

public class ConsumerAdvanced implements Runnable {

	//共享资源对象
	PersonAdvanced p = null;
    
    public ConsumerAdvanced(PersonAdvanced p) {
        this.p = p;
    }
     
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            //消费对象
            p.pop();
        }
    }

}
