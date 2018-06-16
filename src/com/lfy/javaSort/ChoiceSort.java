package com.lfy.javaSort;

/**
 * @author lfy
 * @since 2018/06/16
 * @see  选择排序算法，单元测试可见CaculatorJunitTest
 *       注意每一轮单元素排序，输出对时间的影响
 *       影响性能关键在：元素的比较次数
 * */
public class ChoiceSort {

	public static int[] sort(int[] array){
        //总共要经过N-1轮比较
        for(int i = 0 ; i < array.length-1 ; i++){
            int min = i;
            //每轮需要比较的次数
            for(int j = i+1 ; j < array.length ; j++){
                if(array[j]<array[min]){
                    min = j;//记录目前能找到的最小值元素的下标
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            //第 i轮排序的结果为
//            System.out.print("第"+(i+1)+"轮排序后的结果为:");
//            display(array);
        }
        return array;
    }
 
    //遍历显示数组
    public static void display(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
     
    public static void main(String[] args){
        int[] array = {4,2,8,9,5,7,6,1,3,10,14,17,11,15,12,13,16};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        long startTime=System.currentTimeMillis();
        array = sort(array);
        long endTime=System.currentTimeMillis();
        System.out.println("cost："+(endTime-startTime)+"ms");
        System.out.println("-----------------------");
        System.out.println("经过选择排序后的数组顺序为：");
        display(array);
        System.exit(0);
    }
}
