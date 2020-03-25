package yzh.algorithm;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class No_5_LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        String ss = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) != s.charAt(j)) continue;
                String temp = s.substring(i, j + 1);
                if (temp.equals(reverse.substring(s.length() - j - 1, s.length() - i))) {
                    if (ss.length() < temp.length()) ss = temp;
                }
            }
        }
        return ss;
    }

    public static void main(String[] args) {
        No_5_LongestPalindrome test = new No_5_LongestPalindrome();
        System.out.println(test.longestPalindrome("babad"));
    }
}
