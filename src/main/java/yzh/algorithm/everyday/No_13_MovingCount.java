package yzh.algorithm.everyday;

/**
 * @author yongzh
 * @date 2020/4/8
 */

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class No_13_MovingCount {
    public int movingCount(int m, int n, int k) {
        int sum = Math.min(m, n);
        m = Math.max(m, n);
        n = sum;
        sum = 0;
        for (int i = 0; i < m; i++) {
            int temp = n;
            int index = 0;
            int add = 0;
            while (temp > 0) {
                if (k - i / 10 - i % 10 >= 0) {
                    add +=
                            Math.min(Math.max(k - i / 10 - i % 10 - index + 1
                                    , 0), Math.min(10, temp));
                }
                if (k < i / 10) break;
                temp -= 10;
                index++;
            }
            if (add == 0) break;
            sum += add;
        }
        return sum;
    }

    public int movingCount2(int m, int n, int k) {
        int sum = Math.min(m, n);
        m = Math.max(m, n);
        n = sum;
        sum = 0;
        for (int i = 0; i < m; i++) {
            if (i > k) break;
            if (n > k)
                sum += k - i + 1;
            else {
                sum += Math.max(n - i + 1, 0);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        No_13_MovingCount instance = new No_13_MovingCount();
        System.out.println(instance.movingCount2(1, 2, 1));
    }
}
