package com.lfy.javaSort;

/**
 * @author lfy
 * @since 2018/06/16
 * @see  ð�������㷨����Ԫ���Կɼ�CaculatorJunitTest
 *       ע��ÿһ�ֵ�Ԫ�����������ʱ���Ӱ��
 *       Ӱ�����ܹؼ��ڣ�Ԫ�صıȽϴ���
 * */
public class BubbleSort {

    public static int[] sort(int[] array){
        //����forѭ����ʾ�ܹ���Ҫ�Ƚ϶�����
        for(int i = 1 ; i < array.length; i++){
            //�趨һ����ǣ���Ϊtrue�����ʾ�˴�ѭ��û�н��н�����Ҳ���Ǵ��������Ѿ����������Ѿ���ɡ�
            boolean flag = true;
            //����forѭ����ʾÿ�ֱȽϲ����Ԫ���±�
            //�Ե�ǰ��������array[0......length-i]��������
            //j�ķ�Χ�ܹؼ��������Χ��������С��,��Ϊÿ�ֱȽ϶��Ὣ���ķ����ұ�
            for(int j = 0 ; j < array.length-i ; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            //�� i������Ľ��Ϊ
//            System.out.print("��"+i+"�������Ľ��Ϊ:");
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
     
    public static void main(String[] args) {
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
        System.out.println("����ð������������˳��Ϊ��");
        display(array);
    }
}
