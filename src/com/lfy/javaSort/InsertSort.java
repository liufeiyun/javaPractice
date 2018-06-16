package com.lfy.javaSort;

/**
 * @author lfy
 * @since 2018/06/16
 * @see  ���������㷨����Ԫ���Կɼ�CaculatorJunitTest
 *       ע��ÿһ�ֵ�Ԫ�����������ʱ���Ӱ��
 *       Ӱ�����ܹؼ��ڣ�Ԫ�صıȽϴ���
 * */
public class InsertSort {

	public static int[] sort(int[] array){
        int j;
        //���±�Ϊ1��Ԫ�ؿ�ʼѡ����ʵ�λ�ò��룬��Ϊ�±�Ϊ0��ֻ��һ��Ԫ�أ�Ĭ���������
        for(int i = 1 ; i < array.length ; i++){
            int tmp = array[i];//��¼Ҫ���������
            j = i;
            while(j > 0 && tmp < array[j-1]){//���Ѿ�������������ұߵĿ�ʼ�Ƚϣ��ҵ�����С����
                array[j] = array[j-1];//���Ų��
                j--;
            }
            array[j] = tmp;//���ڱ���С����������
            //�� i������Ľ��Ϊ
//            System.out.print("��"+(i)+"�������Ľ��Ϊ:");
//            display(array);
        }
        return array;
    }
     
    //������ʾ����
    public static void display(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
     
    public static void main(String[] args){
        int[] array = {4,2,16,9,15,7,6,1,3,10,14,17,11,5,12,13,8};
        //δ��������˳��Ϊ
        System.out.println("δ��������˳��Ϊ��");
        display(array);
        System.out.println("-----------------------");
        long startTime=System.currentTimeMillis();
        array = sort(array);
        long endTime=System.currentTimeMillis();
        System.out.println("cost��"+(endTime-startTime)+"ms");
        System.out.println("-----------------------");
        System.out.println("������������������˳��Ϊ��");
        display(array);
        System.exit(0);
    }
}
