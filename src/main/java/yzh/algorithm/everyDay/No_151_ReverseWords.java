package yzh.algorithm.everyDay;

import java.util.Stack;

/**
 * @author yongzh
 * @date 2020/4/10
 */

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class No_151_ReverseWords {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int i = 0;
        StringBuilder temp = new StringBuilder();
        while (i < ch.length) {
            while (i < ch.length && ch[i] != ' ') {
                temp.append(ch[i]);
                i++;
            }
            if (temp.length() != 0) {
                stack.push(temp.toString());
                temp = new StringBuilder();
            }
            i++;
        }
        while (stack.size() != 0) {
            temp.append(stack.pop());
            temp.append(" ");
        }
        return temp.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].length() > 0) {
                sb.append(ss[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
