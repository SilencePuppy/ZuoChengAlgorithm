package com.silence.base.lession2;

/**
 * 对数器
 * 如何设置 0 1 平均发生器
 *
 * @author lixiaobing
 * @Classname Code2_RandomUtil
 * @date 2022-02-18 19:18
 */
public class Code2_RandomUtil {

    private static final int TEST_TIMES = 100000;


    /*****************************已知1-5等概率发生器，获取01等概率发生器*********************************/
    /**
     * 假设这是一个基础的随机数发生器从1-5.已经由第三方或者基础库提供
     *
     * @return {@link int}
     * @author Li Xiaobing
     * @date 2022-02-21 22:14
     */
    private static int alreadyRandom1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * @return {@link int}
     * @author Li Xiaobing
     * @date 2022-02-21 22:15
     */
    private static int convertTo01Random() {
        int i = 0;
        do {
            i = alreadyRandom1To5();
            if (i < 3) {
                return 0;
            }
            if (i > 3) {
                return 1;
            }
        } while (true);

    }
    /****************************************结     束************************************************/


    /*********************************通过01等概率发生器，产生一个等概率的1-8，然后再来个10-27的随机器*****************************************/
    /**
     * 既然我已经有了01发生器，那我就可以等概率的获取其他范围值，因为这些值可以通过二进制的0和1组成
     */
    private static int create1To8RandomBy01() {
        // 考虑模拟电路里面的0和1，一个数字是由多个二进制位的01组成。 000-111 (0-7,每个位置都是等概率0或1)
        // 这里注意运算符优先级的问题。移位运算符的优先级很低
        return (convertTo01Random() << 2) + (convertTo01Random() << 1) + convertTo01Random() + 1;
    }

    private static int create10To27RandomBy01() {
        // 是否会永远的循环下去？ 答：不会，因为Math.Random()是等概率的，0 1发生器也是等概率的，所以从0到31也是等概率出现的，那么就可以将18-31出现的时候再次循环，
        // 这样就可以将这些数值的出现概率平均分配给0-17之间的数值
        int sum;
        do {
            sum = (convertTo01Random() << 4) + (convertTo01Random() << 3) + (convertTo01Random() << 2) + (convertTo01Random() << 1) + convertTo01Random();
        } while (sum > 17);
        return sum+10;
    }


    public static void main(String[] args) {
        int[] counts = new int[28];

        for (int i = 0; i < TEST_TIMES; i++) {
            int k = create10To27RandomBy01();
            counts[k]++;
        }
        for (int i = 0; i < 28; i++) {
            System.out.println(i + ":" + counts[i]);
        }
    }
}
