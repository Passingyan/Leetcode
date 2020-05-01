package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/1
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] temp = new int[nums.length];
        int sum = temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp[i - 1] < 1) {
                temp[i] = nums[i];
            } else {
                temp[i] = temp[i - 1] + nums[i];
            }

            sum = Math.max(sum, temp[i]);
        }
        return sum;
    }
}
