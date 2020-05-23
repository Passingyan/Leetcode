package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/23
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) return 0;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if (nums[i] >= arr[j]) {
                    for (int m = k - 1; m > j; m--) {
                        arr[m] = arr[m - 1];
                    }
                    arr[j] = nums[i];
                    break;
                }
            }
        }
        return arr[k - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new FindKthLargest().findKthLargest(arr, 4));
    }
}
