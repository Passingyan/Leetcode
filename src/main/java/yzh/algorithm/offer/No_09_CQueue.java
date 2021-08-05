package yzh.algorithm.offer;

import java.util.Stack;

/**
 * @author yongzh
 * @date 2021/8/6
 * <p>
 * <p>
 * <node>
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * </node>
 */
public class No_09_CQueue {


    class CQueue {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stackA.push(value);
        }

        public int deleteHead() {
            if (stackB.size() == 0) {
                if (stackA.size() == 0) {
                    return -1;
                }
                while (stackA.size() != 1) {
                    stackB.push(stackA.pop());
                }
                return stackA.pop();
            } else {
                return stackB.pop();
            }
        }
    }
}
