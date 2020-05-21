package me.icro.problems.t21_mergetwolists;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-10 7:49 AM
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = null == l1 ? l2 : l1;
        return preHead.next;
    }
}
