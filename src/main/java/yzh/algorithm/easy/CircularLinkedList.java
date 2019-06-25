package yzh.algorithm.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yzh
 * 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class CircularLinkedList {


    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode second = head.next;
        while (second != null && second.next != null) {
            if (second == head) {
                return true;
            }
            second = second.next.next;
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        head.val = 101010101;
        while (head.next != null) {
            head = head.next;
            if (head.val == 101010101) {
                return true;
            } else {
                head.val = 101010101;
            }
        }
        return false;
    }
}
