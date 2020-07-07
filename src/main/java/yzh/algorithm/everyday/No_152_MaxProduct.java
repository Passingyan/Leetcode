package yzh.algorithm.everyday;

/**
 * @author yongzh
 * @date 2020/5/18
 * <p>
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class No_152_MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] arr = new int[nums.length][];
        int max = nums[0];
        arr[0][0] = nums[0];
        arr[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i][0] = nums[i - 1] * nums[i];
            arr[i][1] = arr[i - 1][1] * nums[i];
        }
        return max;

    }
}
