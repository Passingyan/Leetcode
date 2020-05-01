package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/1
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int sum = 0;
        int[] temp = new int[prices.length];
        temp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= temp[i - 1]) {
                temp[i] = temp[i - 1];
            } else {
                temp[i] = prices[i];
            }
            sum = Math.max(sum, prices[i] - temp[i]);
        }
        return sum;
    }
}
