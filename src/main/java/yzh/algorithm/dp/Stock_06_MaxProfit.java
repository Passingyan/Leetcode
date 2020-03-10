package yzh.algorithm.dp;

public class Stock_06_MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int dp_0 = 0;
        int dp_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp_0 = 0;
                dp_1 = -prices[i];
                continue;
            }
            dp_0 = Math.max(dp_0, dp_1 + prices[i] - fee);
            dp_1 = Math.max(dp_1, dp_0 - prices[i]);
        }
        return dp_0;
    }
}
