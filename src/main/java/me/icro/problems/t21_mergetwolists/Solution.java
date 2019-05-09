package me.icro.problems.t21_mergetwolists;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-10 7:49 AM
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode l1_curr = l1;
        ListNode l2_curr = l2;
        ListNode res_curr = null;
        if (null == l1_curr && null == l2_curr) return null;
        if (null == l1_curr) return l2_curr;
        if (null == l2_curr) return l1_curr;
        if (l1_curr.val < l2_curr.val) {
            res = new ListNode(l1_curr.val);
            res_curr = res;
            l1_curr = l1_curr.next;
        } else {
            res = new ListNode(l2_curr.val);
            res_curr = res;
            l2_curr = l2_curr.next;
        }
        while (null != l1_curr || null != l2_curr) {
            if (null == l1_curr) {
                res_curr.next = new ListNode(l2_curr.val);
                l2_curr = l2_curr.next;
            }
            else if (null == l2_curr) {
                res_curr.next = new ListNode(l1_curr.val);
                l1_curr = l1_curr.next;
            }
            else if (l1_curr.val < l2_curr.val) {
                res_curr.next = new ListNode(l1_curr.val);
                l1_curr = l1_curr.next;
            } else {
                res_curr.next = new ListNode(l2_curr.val);
                l2_curr = l2_curr.next;
            }
            res_curr = res_curr.next;
        }

        return res;
    }
}
