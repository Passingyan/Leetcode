package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/4/12
 */

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (isEquals(s1, s2.substring(i, i + s1.length()))) return true;
        }
        return false;
    }

    public boolean isEquals(String s1, String s2) {
        while (s1.length() != 0) {
            char ch = s1.charAt(0);
            s1 = s1.replace(ch + "", "");
            s2 = s2.replace(ch + "", "");
            if (s1.length() != s2.length()) return false;
        }
        return true;
    }
}
