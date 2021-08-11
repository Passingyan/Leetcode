package yzh.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yongzh
 * @date 2021/8/11
 */
public class No_50_FirstUniqChar {
    public char firstUniqChar(String s) {
        for (char ch : s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return ch;
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
