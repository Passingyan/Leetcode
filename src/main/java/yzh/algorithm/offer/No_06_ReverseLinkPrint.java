package yzh.algorithm.offer;

import yzh.algorithm.common.ListNode;

/**
 * @author yongzh
 * @date 2021/8/7
 *
 * 剑指 Offer 06. 从尾到头打印链表
 *https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class No_06_ReverseLinkPrint {

    class Solution {
        public int[] reversePrint(ListNode head) {
            int[] res = new int[0];
            if (head == null) {
                return res;
            }
            ListNode node = head;
            int index = 0;
            while (node != null) {
                index++;
                node = node.next;
            }
            res = new int[index];
            node = head;
            while (node != null) {
                res[--index] = node.val;
                node = node.next;
            }
            return res;
        }
    }
}
