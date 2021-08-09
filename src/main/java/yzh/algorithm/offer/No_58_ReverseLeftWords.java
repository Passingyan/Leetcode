package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/9
 * <p>
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class No_58_ReverseLeftWords {

    class Solution {
        public String reverseLeftWords(String s, int n) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(n));
            sb.append(s.substring(0, n));
            return sb.toString();
        }
    }
}
