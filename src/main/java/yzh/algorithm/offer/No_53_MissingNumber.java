package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/10
 */
public class No_53_MissingNumber {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
