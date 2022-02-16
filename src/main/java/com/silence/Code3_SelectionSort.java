package com.silence;

/**
 * @author lixiaobing
 * @Classname Code3_SelectionSort
 * @date 2022-02-16 10:17
 */
public class Code3_SelectionSort {

    private static void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[minIndex]<= arr[j]?minIndex:j;
            }
            swap(arr,i,minIndex);
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
