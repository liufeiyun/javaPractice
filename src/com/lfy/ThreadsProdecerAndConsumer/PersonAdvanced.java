package com.lfy.ThreadsProdecerAndConsumer;

public class PersonAdvanced {

	private String name;
    private int age;
    
    //��ʾ������Դ�����Ƿ�Ϊ�գ����Ϊ true����ʾ��Ҫ���������Ϊ false�����������ˣ���Ҫ����
    private boolean isEmpty = true;
     
    /**
     * ��������
     * @param name
     * @param age
     */
    public synchronized void push(String name,int age){
    	try {
            //������ if����Ϊ�����ж���߳�
            while(!isEmpty){//���뵽while����ڣ�˵�� isEmpty==false����ô��ʾ�������ˣ���������������Ҫ�ȴ�����������
                this.wait();//���µ�ǰ�̵߳ȴ�������ȴ����У�ֻ�ܱ������̻߳���
            }
             
            //-------�������ݿ�ʼ-------
            this.name = name;
            //��ʱ����
            Thread.sleep(10);
            this.age = age;
            //-------�������ݽ���-------
            isEmpty = false;//���� isEmpty Ϊ false,��ʾ�Ѿ���������
            this.notifyAll();//������ϣ���������������
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ȡ���ݣ���������
     * @return
     */
    public synchronized void pop(){
    	
    	try {
            //������ if����Ϊ�����ж���߳�
            while(isEmpty){//���� while ����飬��ʾ isEmpty==true,��ʾΪ�գ��ȴ��������������ݣ�������Ҫ����ȴ�����
                this.wait();//�������̵߳ȴ�
            }
            //-------���ѿ�ʼ-------
            Thread.sleep(10);
            System.out.println(this.name+"---"+this.age);
            //-------���ѽ���------
            isEmpty = true;//���� isEmptyΪtrue����ʾ��Ҫ��������������
            this.notifyAll();//������ϣ���������������
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
