package yzh;

import yzh.algorithm.LongestSubstring;
import yzh.algorithm.MedianSortedArrays;

public class Main {
    public static void main(String[] args) {
        findMedianSortedArrays();
    }

    public static void lengthOfLongestSubstring() {
        String s = "abcabcbb";
        System.out.println(LongestSubstring.lengthOfLongestSubstring2(s));
    }

    public static void findMedianSortedArrays() {
        int[] nums1 = {3};
        int[] nums2 = {-2, -1};
        System.out.println(MedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

}
