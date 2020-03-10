package yzh.algorithm.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 */
public class Stock_04_MaxProfit {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        System.out.println(maxProfit(k, prices));
    }

    private static int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (k >= prices.length / 2) {
            int dp_0 = 0;
            int dp_1 = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                int temp = dp_0;
                if (i == 0) {
                    dp_0 = 0;
                    dp_1 = Math.max(dp_1, temp - prices[i]);
                    continue;
                }
                dp_0 = Math.max(dp_1 + prices[i], dp_0);
                dp_1 = Math.max(temp - prices[i], dp_1);
            }
            return dp_0;
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    dp[i][j - 1][0] = 0;
                    dp[i][j - 1][1] = Integer.MIN_VALUE;
                }
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
                }
            }
        }
        return dp[prices.length - 1][k][0];
    }

}
