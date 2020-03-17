package yzh.algorithm.face;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class No_92_ReverseLinkedListBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode temp = head;
        int index = 1;
        ListNode innerFirstNode;
        ListNode innerLastNode = null;
        ListNode outerBeforeNode = null;
        while (temp != null) {
            if (index + 1 == m) outerBeforeNode = temp;
            if (m == index) {
                innerFirstNode = temp;
                ListNode beforNode = temp;
                temp = temp.next;
                index++;
                while (temp != null & index <= n) {
                    if (index == n) innerLastNode = temp;
                    ListNode afterNode = temp.next;
                    temp.next = beforNode;
                    beforNode = temp;
                    temp = afterNode;
                    index++;
                }
                if (m == 1) head = innerLastNode;
                if (outerBeforeNode != null) outerBeforeNode.next = innerLastNode;
                innerFirstNode.next = temp;
            }
            if (temp == null) break;
            temp = temp.next;
            index++;
        }
        return head;

    }

    public static void main(String[] args) {
        int[] arr = {3, 5};
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = node;
        }
        head = reverseBetween(head, 1, 2);
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" -> ");
            head = head.next;
        }
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}



