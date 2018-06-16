package com.lfy.javaSort;

/**
 * @author lfy
 * @since 2018/06/16
 * @see  ѡ�������㷨����Ԫ���Կɼ�CaculatorJunitTest
 *       ע��ÿһ�ֵ�Ԫ�����������ʱ���Ӱ��
 *       Ӱ�����ܹؼ��ڣ�Ԫ�صıȽϴ���
 * */
public class ChoiceSort {

	public static int[] sort(int[] array){
        //�ܹ�Ҫ����N-1�ֱȽ�
        for(int i = 0 ; i < array.length-1 ; i++){
            int min = i;
            //ÿ����Ҫ�ȽϵĴ���
            for(int j = i+1 ; j < array.length ; j++){
                if(array[j]<array[min]){
                    min = j;//��¼Ŀǰ���ҵ�����СֵԪ�ص��±�
                }
            }
            //���ҵ�����Сֵ��iλ�����ڵ�ֵ���н���
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            //�� i������Ľ��Ϊ
//            System.out.print("��"+(i+1)+"�������Ľ��Ϊ:");
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
        int[] array = {4,2,8,9,5,7,6,1,3,10,14,17,11,15,12,13,16};
        //δ��������˳��Ϊ
        System.out.println("δ��������˳��Ϊ��");
        display(array);
        System.out.println("-----------------------");
        long startTime=System.currentTimeMillis();
        array = sort(array);
        long endTime=System.currentTimeMillis();
        System.out.println("cost��"+(endTime-startTime)+"ms");
        System.out.println("-----------------------");
        System.out.println("����ѡ������������˳��Ϊ��");
        display(array);
        System.exit(0);
    }
}
