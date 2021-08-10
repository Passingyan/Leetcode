package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/10
 */
public class No_53_SearchNumberInSortedArr {

    /**
     * for 循环遍历.
     */
    public int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) count++;
            else if (num > target) break;
        }
        return count;
    }


    /**
     * 二分.  还有问题
     */
    public int search2(int[] nums, int target) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left < right) {
            if (nums[left] == target) {
                index = left;
                break;
            }
            if (nums[right] == target) {
                index = right;
                break;
            }
            if (nums[left] > target || nums[right] < target) {
                return 0;
            }

            int mid = (left + right) / 2;
            if (mid >= target) {
                left -= 1;
                right = mid;
            } else {
                left = mid + 1;
                right -= 1;
            }
        }
        left = index - 1;
        while (left > 0) {
            if (nums[left] == target) {
                count++;
            } else if (nums[left] < target) {
                break;
            }
            left--;
        }
        while (index < nums.length) {
            if (nums[index] == target) {
                count++;
            } else if (nums[index] > target) {
                break;
            }
            index++;
        }
        return count;
    }
}
