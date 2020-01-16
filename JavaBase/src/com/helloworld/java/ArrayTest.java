package com.helloworld.java;

/**
 * @author sunjiacheng
 * @create 2019-09-29-14:54
 */
public class ArrayTest
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 6, 5, 2, 1, 4, 7, 5, 3};
        ArrayUtil au = new ArrayUtil();

        int max = au.getMax(arr);
        System.out.println(max);

        int min = au.getMin(arr);
        System.out.println(min);

        int sum = au.getSum(arr);
        System.out.println(sum);

        int avg = au.getAvg(arr);
        System.out.println(avg);

        int[] arr1 = new int[arr.length];
        arr1 = au.copy(arr);
        au.printArray(arr1);

        au.reverse(arr1);
        au.printArray(arr1);

        au.sort(arr, "asc");
        au.printArray(arr);

        au.sort(arr1, "desc");
        au.printArray(arr1);



    }
}
