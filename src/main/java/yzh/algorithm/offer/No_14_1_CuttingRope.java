package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2020/4/7
 */

/**
 * 面试题14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 提示：
 * 2 <= n <= 58
 */
public class No_14_1_CuttingRope {
    /**
     * 在面试时尽量按照常规思路去解，但是大神 @jyd 提出了一种非常巧妙的解法，可将时间复杂度降到 O(1)O(1)，值得我们去学习，
     * 他在 题解 中进行了详细的说明，这里只进行简单的总结。
     * <p>
     * 贪心法则：尽可能分解出多的 3，3 的个数为 a，得到余数 b 可能为 0，1，20，1，2：
     * <p>
     * b = 0，返回 3^a;
     * b = 1，我们将末尾的 3+1 分解成 2×2，因此返回 3^{a-1}x4
     * b = 2，返回 3^ax2
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int cs = n / 3;
        int ys = n % 3;
        if (ys == 0) return (int) Math.pow(3, cs);
        else if (ys == 1)
            return (int) (Math.pow(3, cs - 1) * 4);
        else return (int) (Math.pow(3, cs) * 2);
    }
}
