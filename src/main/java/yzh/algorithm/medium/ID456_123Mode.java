package yzh.algorithm.medium;

import java.util.Arrays;

/**
 * @author yzh
 * @date 2019/10/8
 */
public class ID456_123Mode {

    public static void main(String[] args) {
        int[] nums = {-2, 1, 2, -2, 1, 2};
        System.out.println(find132pattern(nums));
    }

    /**
     * ai < ak < aj，动态规划，正向遍历，找到最小，找到当前数值前最小的值，那样后面找到ak的可能性最大
     */
    public static boolean find132pattern(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        int[] temp = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            if (k == 0) {
                temp[k] = nums[k];
            } else {
                temp[k] = nums[k - 1] < temp[k - 1] ? nums[k - 1] : temp[k - 1];
            }
        }

        // System.out.println(Arrays.toString(temp));
        for (int k = nums.length - 1; k >= 2; k--) {
            int ak = nums[k];
            for (int j = k - 1; j >= 1; j--) {
                int aj = nums[j];
                if (ak >= aj) {
                    continue;
                }
                int ai = temp[j];
                // System.out.println("" + ai + "," + aj + "," + ak);
                if (ai < ak) {
                    return true;
                }
            }
        }
        return false;
    }
}
