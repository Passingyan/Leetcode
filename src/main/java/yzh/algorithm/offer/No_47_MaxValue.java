package yzh.algorithm.offer;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author yongzh
 * @date 2021/8/17
 */
public class No_47_MaxValue {
    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i > 0 && j > 0) {
                    grid[j][i] += Math.max(grid[j - 1][i], grid[j][i - 1]);
                } else if (i > 0) {
                    grid[j][i] += grid[j][i - 1];
                } else if (j > 0) {
                    grid[j][i] += grid[j - 1][i];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
