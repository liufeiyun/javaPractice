package com.lfy.ThreadsProdecerAndConsumer;

/**
 * @see �����������̣߳����� run() ����������50������,��������������û��ȡ��ǰһ�ε�����
 * */
public class ProducerAdvanced implements Runnable {

	//������Դ����
	PersonAdvanced p = null;
    
    public ProducerAdvanced(PersonAdvanced p){
        this.p = p;
    }
    
    @Override
    public void run() {
        //��������
        for(int i = 0 ; i < 50 ; i++){
            //�����ż������ô�������� Tom--11;��������������������� Marry--21
            if(i%2==0){
                p.push("Tom", 11);
            }else{
                p.push("Marry", 21);
            }
        }
    }
}