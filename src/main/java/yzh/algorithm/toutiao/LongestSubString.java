package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/4/11
 */

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int indexCount = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            int index = s.substring(indexCount, i).indexOf(s.charAt(i));
            if (index != -1) indexCount += index + 1;
            max = Math.max(max, i - indexCount + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] ch = s.toCharArray();
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                left = Math.max(left, map.get(ch[i]) + 1);
            }
            map.put(ch[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        System.out.println(longestSubString.lengthOfLongestSubstring("au"));
    }
}
