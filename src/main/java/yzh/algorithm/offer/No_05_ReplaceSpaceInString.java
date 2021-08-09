package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/9
 * <p>
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class No_05_ReplaceSpaceInString {
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : s.toCharArray()) {
                if (ch != ' ') {
                    sb.append(ch);
                } else {
                    sb.append("%20");
                }
            }
            return sb.toString();
        }
    }

}
