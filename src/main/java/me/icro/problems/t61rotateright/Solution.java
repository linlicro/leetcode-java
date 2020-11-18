package me.icro.problems.t61rotateright;

/**
 * @author lin
 * @version v 0.1 2020/11/18
 **/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode fast = tempHead, slow = tempHead;

        int height = 0;
        while (null != fast.next) {
            fast = fast.next;
            height++;
        }
        k %= height;

        for (int index = 0; index < height - k; index++) {
            slow = slow.next;
        }

        fast.next = tempHead.next;
        tempHead.next = slow.next;
        slow.next = null;

        return tempHead.next;
    }
}
