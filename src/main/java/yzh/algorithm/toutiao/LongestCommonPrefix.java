package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/4/12
 */

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String temp = strs[0];
        for (String s : strs) {
            temp = temp.length() > s.length() ? s : temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            boolean flag = true;
            char ch = temp.charAt(i);
            for (String ss : strs) {
                if (ss.charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            sb.append(ch);
        }
        return sb.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        // todo 使用二分查找，优化查询时间
        return "";
    }


    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
