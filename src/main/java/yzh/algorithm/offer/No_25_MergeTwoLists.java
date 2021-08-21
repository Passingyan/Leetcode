package yzh.algorithm.offer;

import yzh.algorithm.common.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author yongzh
 * @date 2021/8/21
 */
public class No_25_MergeTwoLists {
    /**
     * [1,2,4]
     * [1,3,4]
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newNode = l1.val <= l2.val ? l1 : l2;
        ListNode pre = null;
        if (l1 != newNode) {
            l2 = l1;
            l1 = newNode;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (pre != null) {
                    pre.next = l1;
                }
                pre = l1;
                l1 = l1.next;
            } else {
                if (pre != null) {
                    pre.next = l2;
                }
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l2 != null) {
            pre.next = l2;
        }
        if (l1 != null) {
            pre.next = l1;
        }
        return newNode;
    }
}
