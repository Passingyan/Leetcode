package yzh.algorithm.face;

import java.util.Arrays;

/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class No_17_21_Trap {

    /**
     * 解题思路，同时从两边向中间进行遍历，以两高度中较低高度为水平面，计算存水量
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int sum = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                sum += leftMax - height[left++];
                leftMax = Math.max(height[left], leftMax);
            } else {
                sum += rightMax - height[right--];
                rightMax = Math.max(height[right], rightMax);
            }
        }

        return sum;
    }
}
