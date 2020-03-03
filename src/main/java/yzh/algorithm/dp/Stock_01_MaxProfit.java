package yzh.algorithm.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class Stock_01_MaxProfit {

    /**
     * 记录数组当前位置，在它前面的最小值，与自身比较，较小的作为当前位置的值，再进行利润差值计算
     *
     * @param prices
     * @return
     */
    public int maxProfit_mine(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i];
            prices[i] = temp < prices[i - 1] ? temp : prices[i - 1];
            temp -= prices[i];
            maxProfit = maxProfit < temp ? temp : maxProfit;
        }
        return maxProfit;
    }

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
