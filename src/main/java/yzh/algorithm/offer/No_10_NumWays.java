package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/16
 * <p>
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class No_10_NumWays {
    public int numWays(int n) {
        if (n <= 1) return 1;
        int a1 = 1;
        int a2 = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a1 + a2) % 1000000007;
            a1 = a2;
            a2 = sum;
        }
        return sum;
    }
}
