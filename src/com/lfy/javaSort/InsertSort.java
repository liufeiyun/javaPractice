package com.lfy.javaSort;

/**
 * @author lfy
 * @since 2018/06/16
 * @see  插入排序算法，单元测试可见CaculatorJunitTest
 *       注意每一轮单元素排序，输出对时间的影响
 *       影响性能关键在：元素的比较次数
 * */
public class InsertSort {

	public static int[] sort(int[] array){
        int j;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for(int i = 1 ; i < array.length ; i++){
            int tmp = array[i];//记录要插入的数据
            j = i;
            while(j > 0 && tmp < array[j-1]){//从已经排序的序列最右边的开始比较，找到比其小的数
                array[j] = array[j-1];//向后挪动
                j--;
            }
            array[j] = tmp;//存在比其小的数，插入
            //第 i轮排序的结果为
//            System.out.print("第"+(i)+"轮排序后的结果为:");
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
        int[] array = {4,2,16,9,15,7,6,1,3,10,14,17,11,5,12,13,8};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        long startTime=System.currentTimeMillis();
        array = sort(array);
        long endTime=System.currentTimeMillis();
        System.out.println("cost："+(endTime-startTime)+"ms");
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
        System.exit(0);
    }
}
