package yzh.algorithm;

/**
 * @Author yzh
 * @Date 2019/4/8
 **/
public class MedianSortedArrays {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的平均值，并且要求算法的时间复杂度为 O(log(m + n))。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medium = (nums1.length + nums2.length - 1) / 2;
        double sum = MedianSortedArrays.calculateSumOfArrays(medium,
                0, nums1.length + nums2.length - 1, nums1, nums2);
        return sum / (nums1.length + nums2.length);
    }

    public static double calculateSumOfArrays(int medium, int lengthBeg, int lengthEnd, int[] nums1, int[] nums2) {
        if (medium == lengthBeg) {
            if (lengthBeg == lengthEnd) {
                if (medium >= nums1.length) {
                    return nums2[medium - nums1.length];
                } else {
                    return nums1[medium];
                }
            } else {
                if (medium >= nums1.length) {
                    return nums2[medium - nums1.length] + nums2[medium - nums1.length + 1];
                } else {
                    if (lengthEnd >= nums1.length) {
                        return nums1[medium] + nums2[lengthEnd - nums1.length];
                    } else {
                        return nums1[medium] + nums1[lengthEnd];
                    }
                }
            }
        }
        int leftMedium = (lengthBeg + medium) / 2;
        int rightMedium = (lengthEnd + medium + 1) / 2;
        return MedianSortedArrays.calculateSumOfArrays(leftMedium, lengthBeg, medium, nums1, nums2) +
                MedianSortedArrays.calculateSumOfArrays(rightMedium, medium + 1, lengthEnd, nums1, nums2);
    }
}
