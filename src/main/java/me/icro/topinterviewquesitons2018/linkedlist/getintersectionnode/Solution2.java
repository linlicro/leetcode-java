package me.icro.topinterviewquesitons2018.linkedlist.getintersectionnode;

/**
 * 描述:
 *
 *  解题思路: 如果两个链表相交，那么相交点之后的长度是相同的。通过「消除两个链表的长度差」来找到相交点
 *
 *  空间复杂度 O(1) 时间复杂度O(n)
 *
 * @author Lin
 * @since 2019-07-26 11:30 AM
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
