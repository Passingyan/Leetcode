package yzh.algorithm.face;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 */
public class No_01_02_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        while (s1.length() > 0) {
            String temp = s1.substring(0, 1);
            s1 = s1.replace(temp, "");
            s2 = s2.replace(temp, "");
            if (s1.length() != s2.length()) return false;
        }
        return true;
    }
}
