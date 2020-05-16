package yzh.algorithm.toutiao;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yongzh
 * @date 2020/5/16
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] paths = path.split("/");
        for (String ss : paths) {
            if (ss.length() == 0 || ss.equals(".")) {
                continue;
            } else {
                if (ss.equals("..") && deque.size() > 0) {
                    deque.removeLast();
                } else if (!ss.equals("..")) {
                    deque.addLast(ss);
                }
            }
        }
        if (deque.size() == 0) return "/";
        StringBuilder sb = new StringBuilder();
        while (deque.size() > 0) {
            sb.append("/");
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/../"));
    }
}
