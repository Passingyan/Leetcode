package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/17
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0;
        int lenB = 0;
        while (!(tempA == null && tempB == null)) {
            if (tempA != null) {
                lenA++;
                tempA = tempA.next;
            }
            if (tempB != null) {
                lenB++;
                tempB = tempB.next;
            }
        }
        int i = 0;
        tempA = lenA >= lenB ? headA : headB;
        tempB = lenA < lenB ? headA : headB;

        while (i < Math.abs(lenA - lenB)) {
            tempA = tempA.next;
            i++;
        }
        while (tempA != null && tempB != null) {
            if (tempA.equals(tempB))
                return tempA;
            else {
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        return null;
    }
}
