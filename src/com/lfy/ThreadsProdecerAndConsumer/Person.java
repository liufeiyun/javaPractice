package com.lfy.ThreadsProdecerAndConsumer;

/**
 * ����������ͨ��java���߳�ѧϰ�������Ѿ��˽��˶��̻߳�����֪ʶ
 *    1����������� 
 *    2�����̡��̵߳Ĵ���
 *    3���̵߳�ͬ��
 *    
 *    ��һ��������ѧϰ�����ߺ�������ģ�ͣ�
 *       ������Producer����ĳ�����󣨹�����Դ�������ڻ�����У�Ȼ��������Consumer�ӻ������ȡ���������
 *       
 *       Ҳ��������������һ��������������һ������������ѭ����
 *
 *    */
/**
 * @see  ��һ���������ȴ���������Դ���� Person,��������������һ����������һ�����Ѷ���
 *       ��һ������������Producer�߳��ࡣ
 * */
public class Person {

	private String name;
    private int age;
     
    /**
     * ��������
     * @param name
     * @param age
     */
    public synchronized void push(String name,int age){
        this.name = name;
        try {
        	/**
        	 * ��ʱ���㷢�֣�����Ԥ����������ΪMarry---21��ż��Tom--11������Ϊ�̲߳�ͬ�������⣬
        	 * ʹ�������޸�name��age��ʱ��Ҳ�����˴�λ��������ȡ��ʱ��õ���2��2�η��ֽ�����ܡ�
        	 * �����δ���ֻ��Ϊ���ý�������ԣ���û����δ���ʱ�����̵߳��������
        	 *    this.name = name;
        	 *    this.age = age;
        	 * ֮�����д���֮��Ҳ�ǻ�������������ʱ��ġ�
        	 * */
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        this.age = age;
    }
    
    /**
     * ȡ���ݣ���������
     * @return
     */
    public synchronized void pop(){
    	
    	try {
    		/**
    		 * �����δ����������������е����ԭ����ͬ
    		 * */
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(this.name+"---"+this.age);
    }
}
