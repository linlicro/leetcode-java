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
        ListNode cur = head;
        ListNode next = null;
        while (null != cur) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
