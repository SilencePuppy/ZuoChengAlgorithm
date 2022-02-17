package com.silence.base.lession1;

/**
 * 阶乘累加和
 * 1!+2!+....N!
 * @author lixiaobing
 * @Classname Code02_SumOfFactorial
 * @date 2022-02-16 9:26
 */
public class Code02_SumOfFactorial {
    public static int sumFactorial(int n) {
        int sum = 1,preData = 1;
        for (int i = 2; i <= n ; i++) {
            preData = preData*i;
            sum +=preData;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = sumFactorial(3);
        System.out.println(i);
    }
}
