package com.silence.base.lession2;

/**
 * 前缀和问题。
 * 你有一个一维整形数组，输入两个索引值，R,L.
 * 求L-R位置数据的累加和。请求量很大
 *
 * @author lixiaobing
 * @Classname Code1_PrefixSum
 * @date 2022-02-17 15:05
 */
public class Code1_PrefixSum {
    static int[] arr = new int[]{1, 3, 2, 3, 7, -1, 8, 19, 21, 20, 31,12,22,-21};

    // 普通方法，直接暴力求解
    public static void calcSum(int left,int right) {
        if (left > right|| left<0||right>=arr.length) {
            return ;
        }
        int sum = 0;
        for (int i = left; i <=right ; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }

    // 提前全部求解,然后放到二维数组里
    static int[][] sumArr;
    static {
        sumArr = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            sumArr[i][i] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + arr[j];
            }
        }
    }

    public static void calcSum2(int left,int right){
        if (left > right|| left<0||right>=arr.length) {
            return ;
        }

        System.out.println(sumArr[left][right]);
    }

    static int[] sumArr2;

    static {
        sumArr2 = new int[arr.length];
        sumArr2[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArr2[i] = sumArr2[i - 1] + arr[i];
        }
    }

    public static void calcSum3(int left,int right){
        if (left > right|| left<0||right>=arr.length) {
            return ;
        }
        if (left == 0) {
            System.out.println(sumArr2[right]);
        }
        System.out.println(sumArr2[right]-sumArr2[left-1]);
    }


    public static void main(String[] args) {
        int left=9,right =9;
        calcSum(left,right);
        calcSum2(left,right);
        calcSum3(left, right);
    }
}
