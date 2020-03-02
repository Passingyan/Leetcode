package yzh.algorithm.easy;


/**
 * 面试题15. 二进制中1的个数
 */
public class Offer_HammingWeight {
    public static void main(String[] args) {

        System.out.println(hammingWeight(7));
    }

    static int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= (n - 1);
            ret++;
        }
        return ret;
    }
}
