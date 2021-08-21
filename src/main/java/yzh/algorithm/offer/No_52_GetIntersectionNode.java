package yzh.algorithm.offer;

import yzh.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * @author yongzh
 * @date 2021/8/21
 */
public class No_52_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> help = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (help.contains(headA)) {
                    return headA;
                }
                help.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (help.contains(headB)) {
                    return headB;
                }
                help.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 数学思路：
     * Link A 的长度为 a+c
     * LinK B 的长度为 b+c
     * 其中 a为 A中不相交的长度，b为B中不相交的长度，c为相同的长度（看可能为0）
     * 则走到相交节点的长度是   a+c+b 和 b+c+a
     * <p>
     * 可以使用双执政，pA = headA， pB = headB，pA走完指向headB，pB走完指向headA，
     * 则最终 pA肯定会等于pB
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
