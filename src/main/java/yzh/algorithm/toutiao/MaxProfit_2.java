package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/1
 */
public class MaxProfit_2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
