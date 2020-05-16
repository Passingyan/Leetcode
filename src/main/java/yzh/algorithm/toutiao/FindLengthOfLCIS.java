package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/16
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int length = 1;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length = Math.max(length, i - left + 1);
            } else {
                left = i;
            }
        }
        return length;
    }
}
