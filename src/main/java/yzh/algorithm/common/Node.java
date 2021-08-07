package yzh.algorithm.common;

/**
 * @author yongzh
 * @date 2021/8/7
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
