package yzh.algorithm;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */

public class No_25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode temp = head.next;
        ListNode begin = head;
        ListNode indexNode = begin;
        ListNode front = null;
        int index = 2;
        while (temp != null) {
            if (begin == null) {
                begin = temp;
                indexNode = begin;
            }
            ListNode node = temp.next;
            if (index / k != 0) {
                if (node != null) {
                    temp.next = indexNode;
                    indexNode = temp;
                } else {
                    temp.next = indexNode;
                    if (front == null) head = temp;
                    else {
                        front.next = temp;
                    }
                    break;
                }
            } else {
                if (front != null) {
                    front.next = temp;
                } else {
                    head = temp;
                }
                front = begin;
                begin = null;
                indexNode = null;
            }
            temp = node;
            index++;
        }
        return head;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode temp = head;
        ListNode front = null;
        while (temp != null) {
            ListNode before = temp;
            ListNode[] arr = reverseList(temp, k);
            ListNode newFirst = arr[0];
            if (front != null) {
                front.next = newFirst;

            } else {
                head = newFirst;
            }
            front = before;
            temp = arr[1];
        }
        return head;
    }

    public static ListNode[] reverseList(ListNode node, int k) {
        ListNode end = node;
        ListNode before = node;
        node = node.next;
        k--;
        while (k > 0 && node != null) {
            before = end;
            end = node;
            end.next = before;
            node = node.next;
            k--;
        }
        ListNode[] arr = {end, node};
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = node;
        }
        head = reverseKGroup2(head, k);
        while (head != null) {
            System.out.print(head.val + "  ");
        }
    }
}
