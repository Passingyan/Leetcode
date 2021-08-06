package yzh.algorithm.offer;

import java.util.Stack;

/**
 * @author yongzh
 * @date 2021/8/6
 * <p>
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class No_30_MinStack {
    class MinStack {

        /**
         * initialize your data structure here.
         * 使用两个栈，一个作为正常的数据栈，一个作为min的辅助栈。
         * 每当压栈时，压栈数据小于等于当前min值时，则辅助栈也同步压栈。
         * 当正常出栈时，出栈数据等于当前min值时，则辅助栈也同步出栈。
         */
        Stack<Integer> stackA;
        Stack<Integer> stackB;

        public MinStack() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void push(int x) {
            stackA.push(x);
            if (stackB.size() == 0 || stackB.peek() >= x) {
                stackB.push(x);
            }
        }

        public void pop() {
            if (stackA.pop().equals(stackB.peek())) {
                stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int min() {
            return stackB.peek();
        }
    }
}
