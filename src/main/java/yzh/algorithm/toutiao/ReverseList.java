package yzh.algorithm.toutiao;

import yzh.algorithm.common.ListNode;

/**
 * @author yongzh
 * @date 2020/4/19
 * <p>
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode newHead = head;
        while (newHead != null) {
            ListNode tp = newHead.next;
            newHead.next = temp;
            temp = newHead;
            newHead = tp;
        }
        return temp;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head;
        while (newHead.next != null) {
            newHead = newHead.next;
        }

        recursive(head);
        head.next = null;

        return newHead;
    }

    private ListNode recursive(ListNode node) {
        ListNode next = node.next;
        if (next != null) {
            next = recursive(next);
            next.next = node;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tp = new ListNode(arr[i]);
            temp.next = tp;
            temp = tp;
        }
        head = new ReverseList().reverseList1(head);
        System.out.println("666");


    }
}
