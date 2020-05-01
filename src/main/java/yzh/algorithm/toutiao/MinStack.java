package yzh.algorithm.toutiao;


import java.util.Stack;

/**
 * @author yongzh
 * @date 2020/5/1
 */
public class MinStack {

    class Node {
        public Node next;
        public int value;

        public Node(int num) {
            this.value = num;
            next = null;
        }
    }

    private Node head;
    private Stack<Integer> stack = new Stack<>();

    public MinStack() {
        this.head = null;
    }

    public void push(int x) {
        stack.push(x);
        adapt(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return head.value;
    }

    private void adapt(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
        }
        if (head.value >= x) {
            node.next = head;
            head = node;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.value < x) {
                    if (temp.next == null) {
                        temp.next = node;
                        break;
                    } else if (temp.next.value > x) {
                        node.next = temp.next;
                        temp.next = node;
                        break;
                    }
                }
                temp = temp.next;
            }
        }
    }

}
