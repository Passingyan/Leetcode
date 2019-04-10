package yzh.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yzh
 * @Date 2019/4/8
 **/
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        if (s.length() == 2 && (s.charAt(0) == s.charAt(1))) {
            return 1;
        }
        int tail = 1;
        int maxLength = 1;
        String temp = String.valueOf(s.charAt(0));
        while (tail < s.length()) {
            if (temp.contains(String.valueOf(s.charAt(tail)))) {
                int index = temp.indexOf(s.charAt(tail));
                if (index == temp.length()) {
                    temp = String.valueOf(s.charAt(tail));
                } else {
                    temp = temp.substring(index + 1, temp.length()) + s.charAt(tail);
                }
            } else {
                temp += s.charAt(tail);
            }
            maxLength = maxLength >= temp.length() ? maxLength : temp.length();
            tail++;
        }
        // System.out.println(temp);
        return maxLength;
    }


    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        if (s.length() == 2 && (s.charAt(0) == s.charAt(1))) {
            return 1;
        }
        char[] ch = s.toCharArray();
        int head = 0;
        int tail = 1;
        int maxLength = 1;
        String temp = String.valueOf(ch[0]);
        while (tail < ch.length) {
            if (temp.contains(String.valueOf(ch[tail]))) {
                head += temp.indexOf(ch[tail]) + 1;
                if (head == tail) {
                    temp = String.valueOf(ch[tail]);
                } else {
                    temp = temp.substring(temp.indexOf(ch[tail]) + 1, temp.length()) + ch[tail];
                }
            } else {
                temp += s.charAt(tail);
            }
            maxLength = maxLength >= temp.length() ? maxLength : temp.length();
            tail++;
        }
        // System.out.println(temp);
        return maxLength;
    }


    public int lengthOfLongestSubstring3(String s) {
        /*
         *  leetcode解法
         */
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
