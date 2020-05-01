package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/1
 */
public class SearchInArray {
    public int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            mid = (left + right) / 2;
            if (nums[0] <= nums[mid] && nums[0] <= target && nums[mid] >= target) {
                right = mid;
            } else if (nums[0] > nums[mid] && nums[0] <= target) {
                right = mid;
            } else if (nums[0] > nums[mid] && nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
            //
            //
            // if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
            //     left = mid + 1;
            // else
            //     right = mid;
        }
        return left == right && nums[left] == target ? left : -1;

    }
}
