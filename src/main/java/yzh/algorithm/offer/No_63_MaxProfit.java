package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/16
 * <p>
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class No_63_MaxProfit {

    /**
     * 价格数组，遍历时，寻找已遍历中最小价格和最大价格，且 最小价格下标 < 最大价格下标；
     * 当遇到更小价格时，则计算之前的利润，取最大值，
     * 更新之前的最小价格、最大价格都为当前的最小价格.
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        int maxPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
            if (prices[i] < minPrice) {
                maxProfit = Math.max(maxProfit, maxPrice - minPrice);
                minPrice = prices[i];
                maxPrice = prices[i];
            }
        }
        return Math.max(maxProfit, maxPrice - minPrice);
    }

    public static void main(String[] args) {
        No_63_MaxProfit maxProfit = new No_63_MaxProfit();
        int[] prices = {1, 2};
        System.out.println(maxProfit.maxProfit(prices));
    }
}
