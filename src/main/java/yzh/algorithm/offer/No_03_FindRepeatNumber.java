package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/10
 * <p>
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class No_03_FindRepeatNumber {
    /**
     * 使用一个同长的数组，将原数组的每个值放置其下标所在位置的新数组中，
     * 当放置过程中，存在 old == new，则表示之前存放时以后相同的值存入
     */
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = -1;
        for (int num : nums) {
            if (num == temp[num]) {
                return num;
            }
            temp[num] = num;
        }
        return -1;
    }

    /**
     * 原地寻址，核心的地方在于 index 下标值的移动.
     */
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
