package com.silence.base.lession1;

/**
 * 插入
 * @author lixiaobing
 * @Classname Code5_InsertingSort
 * @date 2022-02-17 9:50
 */
public class Code5_InsertingSort {


    private static void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int j = i-1;

            for (; j > 0&&arr[j]>arr[i]; j--);

            if (j != i - 1) {
                int temp = arr[i];
                System.arraycopy(arr,j+1,arr,j+2,i-j-1);
                arr[j+1] = temp;
            }

        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 44, 23, 113, 52, 56, 33, 566};
        printArray(arr);
        sort(arr);
        printArray(arr);
    }
}
