package yzh.algorithm.face;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 */
public class No_01_01_StringIsUnique {
    public boolean isUnique(String astr) {
        char[] ch = astr.toCharArray();
        if (ch.length == 0) return true;
        StringBuilder sb = new StringBuilder();
        sb.append(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            if (sb.toString().contains(String.valueOf(ch[i]))) {
                return false;
            }
            sb.append(ch[i]);
        }
        return true;
    }
}
