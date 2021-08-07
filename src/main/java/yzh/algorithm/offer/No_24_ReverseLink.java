package yzh.algorithm.offer;

import yzh.algorithm.common.ListNode;

/**
 * @author yongzh
 * @date 2021/8/7
 * <p>
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class No_24_ReverseLink {

    public ListNode reverseList(ListNode head) {
        ListNode preNode;
        ListNode curNode = null;
        while (head != null) {
            preNode = curNode;
            curNode = head;
            head = head.next;
            curNode.next = preNode;
        }
        return curNode;
    }
}
