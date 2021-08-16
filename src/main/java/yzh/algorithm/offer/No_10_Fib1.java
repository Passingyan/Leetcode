package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/16
 * <p>
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class No_10_Fib1 {
    public int fib(int n) {
        if (n <= 1) return n;
        int n1 = 0;
        int n2 = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        No_10_Fib1 no_10_fib1 = new No_10_Fib1();
        for (int i = 2; i <= 45; i++) {
            System.out.println(no_10_fib1.fib(i));
        }
    }
}
