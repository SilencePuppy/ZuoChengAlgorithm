package com.silence.base.lession1;

/**
 * 打印32位整数 int 的二进制形式
 * @author lixiaobing
 * @Classname Code01_PrintBinary
 * @date 2022-02-16 8:58
 */
public class Code01_PrintBinary {
    public static void printBinary(int data){
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append((data&(1<<i))==0?"0":"1");
        }
        System.out.println(sb.reverse().toString());
    }

    public static void main(String[] args) {
        printBinary(1);
        printBinary(-1);
        printBinary(Integer.MIN_VALUE);
    }
}
