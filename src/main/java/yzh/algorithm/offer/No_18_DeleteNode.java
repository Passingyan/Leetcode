package yzh.algorithm.offer;

import yzh.algorithm.common.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author yongzh
 * @date 2021/8/21
 */
public class No_18_DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = null;
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val != val) {
                pre = temp;
                if (newHead == null) {
                    newHead = temp;
                }
            } else {
                if (pre != null) {
                    pre.next = temp.next;
                }
            }
            temp = temp.next;
        }
        return newHead;
    }
}
