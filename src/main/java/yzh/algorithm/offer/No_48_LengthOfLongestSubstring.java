package yzh.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 *
 * @author yongzh
 * @date 2021/8/21
 */
public class No_48_LengthOfLongestSubstring {
    /**
     * 解题思路：
     *  寻找不重复的最长子串，单次遍历，可以使用map存放字符上次出现的位置下标，同时记录子串的开始位置，
     *  通过遍历字符，确认字符是否已在map中存在，且下标是大于子串的开始位置，则出现了重复，此时计算子串
     *  长度，并与之前的子串长度比较取较大值，最后重置新子串的起始位置，即当前字符在map中记录的下标的下一个。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        int begin = 0;
        int index = 0;
        int length = 0;
        char ch;
        while (index < s.length()) {
            ch = s.charAt(index);
            if (indexMap.containsKey(ch)) {
                if (indexMap.get(ch) >= begin) {
                    length = Math.max(length, index - begin);
                    begin = indexMap.get(ch) + 1;
                }
            }
            indexMap.put(ch, index);
            index++;
        }
        return Math.max(length, index - begin);
    }

    public static void main(String[] args) {
        No_48_LengthOfLongestSubstring lengthOfLongestSubstring =
                new No_48_LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("dvdf"));
    }
}
