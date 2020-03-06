package yzh.algorithm.dp;


/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 */
public class Stock_03_MaxProfit {
    public static void main(String[] args) {
        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        // int[] prices = {1, 2, 3, 4, 5};
        // int[] prices = {7,6,4,3,1};
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfitMine(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int secondProfit = 0;
        boolean flag = true;
        int[] relatedMin = new int[prices.length];
        relatedMin[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                relatedMin[i] = relatedMin[i - 1];
                int profit = prices[i] - relatedMin[i];
                if (maxProfit == 0) {
                    maxProfit = profit;
                } else if (!flag) {
                    if (profit > maxProfit) {
                        secondProfit = maxProfit;
                        maxProfit = profit;
                    } else if (profit > secondProfit) {
                        secondProfit = profit;
                    }
                } else {
                    if (secondProfit != 0) {
                        if (profit > maxProfit) {
                            secondProfit = maxProfit;
                            maxProfit = profit;
                        } else if (profit > secondProfit) {
                            secondProfit = profit;
                        }
                    } else {
                        maxProfit = maxProfit > profit ? maxProfit : profit;
                    }
                }

            } else {
                relatedMin[i] = prices[i];
                flag = false;
            }
        }
        System.out.println(maxProfit);
        System.out.println(secondProfit);
        return maxProfit + secondProfit;
    }

    public static int maxProfit(int[] prices) {
        int dp_1_0 = 0;
        int dp_1_1 = Integer.MIN_VALUE;
        int dp_2_0 = 0;
        int dp_2_1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            dp_1_0 = Math.max(dp_1_0, dp_1_1 + prices[i]);
            dp_1_1 = Math.max(-prices[i], dp_1_1);
            dp_2_0 = Math.max(dp_2_1 + prices[i], dp_2_0);
            dp_2_1 = Math.max(dp_1_0 - prices[i], dp_2_1);
        }
        return dp_2_0;

    }
}
