package yzh.algorithm.face;

/**
 * @author yongzh
 * @date 2020/5/1
 */

/**
 * 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 */
public class No_17_10_MajorityElement {
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }

        int len = (nums.length + 1) / 2;
        count = 0;
        for (int num : nums) {
            if (temp == num) count++;
            if (count == len) return temp;
        }
        return -1;

    }
}
