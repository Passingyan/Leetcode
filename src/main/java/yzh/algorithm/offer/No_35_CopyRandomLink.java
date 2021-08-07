package yzh.algorithm.offer;

import yzh.algorithm.common.Node;

import java.util.*;

/**
 * @author yongzh
 * @date 2021/8/7
 * <p>
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class No_35_CopyRandomLink {
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            // 利用map保存旧、新 node的关联关系
            Map<Node, Node> nodeMap = new HashMap<>();
            // 第一步，创建所有对应的新Node，存到map中
            Node cur = head;
            while (cur != null) {
                nodeMap.put(cur, new Node(cur.val));
                cur = cur.next;
            }

            // 第二步，复制所有旧node的next、random关联关系到新node上
            cur = head;
            while (cur != null) {
                nodeMap.get(cur).next = nodeMap.get(cur.next);
                nodeMap.get(cur).random = nodeMap.get(cur.random);
                cur = cur.next;
            }

            return nodeMap.get(head);
        }


        public Node copyRandomList2(Node head) {
            if (head == null) {
                return head;
            }

            // 第一步，创建所有新node，并插入到旧node之后，进行串联起
            // 形如 node1 -> node1New -> node2 -> node2New
            Node cur = head;
            while (cur != null) {
                Node newNode = new Node(cur.val);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = newNode.next;
            }

            // 第二步，更改新node的random指向
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            // 第三步，拆分旧、新链表
            cur = head;
            Node newHead = cur.next;
            Node oldPre = cur;
            Node newPre = newHead;
            cur = cur.next.next;
            while (cur != null) {
                oldPre.next = cur;
                newPre.next = cur.next;
                oldPre = oldPre.next;
                newPre = newPre.next;
                cur = cur.next.next;
            }
            oldPre.next = null;
            newPre.next = null;


            return newHead;
        }

    }
}
