package com.lfy.ThreadsProdecerAndConsumer;

public class ConsumerAdvanced implements Runnable {

	//������Դ����
	PersonAdvanced p = null;
    
    public ConsumerAdvanced(PersonAdvanced p) {
        this.p = p;
    }
     
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            //���Ѷ���
            p.pop();
        }
    }

}
