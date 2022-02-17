package com.silence.base.lession1;

/**
 * 冒泡
 * @author lixiaobing
 * @Classname Code04_BubblingSort
 * @date 2022-02-17 9:35
 */
public class Code04_BubblingSort {
    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = N-1; i >0 ; i--) {
            boolean isOk = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isOk = false;
                    swap(arr, j, j + 1);
                }
            }
            if (isOk) {
                break;
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
