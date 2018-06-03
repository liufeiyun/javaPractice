package com.lfy.SingletonMode;

/**
 * 1��ʲô�ǵ���ģʽ<br>
 * ��ȡһ���İ취��֤���������ϵͳ�У�����ģʽȷ������ĳ����ֻ�ܴ���һ��ʵ���������������ص㣺<br>

�����١�������ֻ����һ��ʵ��<br>

�����ڡ�����������Լ������Լ���ʵ��<br>

�����ۡ�����������ṩ����ȡ���ʵ���ķ���<br>

   2������������˼��<br>
   �١���粻�ܴ���������ʵ������ô���뽫������˽�л���<br>
   
   public class Singleton {
      //������˽�л�
      private Singleton(){
      
      }
   }
   
   �ڡ�����������Լ������Լ���ʵ������������������ⲿ�޸��ڲ�������ʵ�������Խ����ʵ���� private ������
   Ϊ������ܷ��ʵ����ʵ�������ǻ������ṩ get �����õ����ʵ������Ϊ��粻�� new ����࣬�������Ǳ����� static �������ֶκͷ�����<br>
    //������ڲ��Լ�����ʵ��
    private static Singleton singleton = new Singleton();
 
    //�ṩget �����Թ�����ȡ����
    public Singleton getInstance(){
        return singleton;
    }
*/
/**
 * 1������ģʽ֮����ģʽ
 * @author lfy
 * @since 2018/06/03
 * @see   ����ģʽ�����˶��̵߳�ͬ�����⣬������ ��װ�ص�ʱ��ͽ�����ʵ�������п������ʵ�������̺ܳ�����ô�ͻ�Ӵ���װ�ص�ʱ�䣻
 *        �п������ʵ���ֽ׶θ����ò�������ô���������ʵ����Ҳ���˷��ڴ档û�дﵽ lazy-loading ��Ч����
 * */
public class SingletonMode1 {
	
	//������˽�л�
    private SingletonMode1(){
         
    }
    
    //������ڲ��Լ�����ʵ��
    private static SingletonMode1 singleton = new SingletonMode1();
 
    //�ṩget �����Թ�����ȡ����
    public static SingletonMode1 getInstance(){
        return singleton;
    }
    
    public static void main(String[] args) {
        SingletonMode1 s1 = SingletonMode1.getInstance();
        SingletonMode1 s2 = SingletonMode1.getInstance();
        System.out.println(s1.equals(s2)); //true
    }
}
