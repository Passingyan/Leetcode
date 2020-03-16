package yzh.algorithm.face;

import java.util.LinkedHashSet;
import java.util.Set;

public class No_02_01_RemoveDuplicateNodes {
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        ListNode tempHead = head;
        while (tempHead != null) {
            ListNode temp = tempHead.next;
            ListNode constNode = tempHead;
            while (temp != null) {
                if (temp.val == tempHead.val) {
                    temp = temp.next;
                    if (temp == null) constNode.next = temp;
                    continue;
                }
                constNode.next = temp;
                temp = temp.next;
                constNode = constNode.next;
            }
            tempHead = tempHead.next;
        }
        return head;
    }

    public static ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) return head;
        Set<Integer> valSet = new LinkedHashSet<>();
        valSet.add(head.val);
        ListNode temp = head.next;
        ListNode constNode = head;
        while (temp != null) {
            if (valSet.contains(temp.val)) {
                temp = temp.next;
                if (temp == null) constNode.next = temp;
                continue;
            }
            valSet.add(temp.val);
            constNode.next = temp;
            temp = temp.next;
            constNode = constNode.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2};
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        head = removeDuplicateNodes(head);
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
    }
}
