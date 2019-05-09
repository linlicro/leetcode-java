package me.icro.problems.t206_reverselist;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-09 4:19 PM
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
