package yzh.algorithm.face;


import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class No_03_04_MyQueue {
    public static void main(String[] args) {
        /**
         * ["MyQueue","push","push","push","peek","pop","peek","pop","peek","empty","pop","empty"]
         * [[],[1],[2],[3],[],[],[],[],[],[],[],[]]
         */
        String[] str = {"MyQueue", "push", "push", "push", "peek", "pop", "peek", "pop", "peek", "empty", "pop", "empty"};
        Object[] num = {null, 1, 2, 3, null, null, null};
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "MyQueue":
                    break;
                case "push":
                    myQueue.push((Integer) num[i]);
                    break;
                case "peek":
                    System.out.println(myQueue.peek());
                    break;
                case "pop":
                    System.out.println(myQueue.pop());
                    break;
                case "empty":
                    System.out.println(myQueue.empty());
                    break;
                default:
                    break;
            }
        }
    }
}

class MyQueue {

    private Stack<Integer> stackOne = new Stack<>();
    private Stack<Integer> stackTwo = new Stack<>();
    private int front = Integer.MIN_VALUE;


    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stackTwo.size() != 0) {
            int length = stackTwo.size();
            for (int i = 1; i <= length; i++) {
                stackOne.push(stackTwo.pop());
                i++;
            }
        }
        stackOne.push(x);
        if (stackOne.size() == 1) front = x;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int result;
        if (stackOne.size() != 0) {
            int length = stackOne.size();
            for (int i = 1; i <= length; i++) {
                stackTwo.push(stackOne.pop());
            }
        }
        result = stackTwo.pop();
        if (stackTwo.size() != 0) front = stackTwo.peek();
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }
}
