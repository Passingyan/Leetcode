package yzh.algorithm.face;

public class No_02_03_DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode temp;
        while (node.next != null) {
            temp = node.next;
            node.val = temp.val;
            if (temp.next == null) {
                node.next = null;
                break;
            }
            node = temp;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}