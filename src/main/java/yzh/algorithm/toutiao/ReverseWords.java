package yzh.algorithm.toutiao;

import java.util.Stack;

/**
 * @author yongzh
 * @date 2020/5/16
 */
public class ReverseWords {

    public String reverseWords(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder temp;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                temp = new StringBuilder();
                while (index < s.length() && s.charAt(index) != ' ') {
                    temp.append(s.charAt(index));
                    index++;
                }
                stack.push(temp);
            } else {
                index++;
            }
        }
        temp = new StringBuilder();
        while (stack.size() != 0) {
            temp.append(stack.pop());
            temp.append(" ");
        }
        return temp.toString().trim();
    }
}
