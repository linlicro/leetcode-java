package me.icro.problems.t19_removenthfromend;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-09 3:10 PM
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return null;

        ListNode pre_nth_from_end = null, nth_from_end = null, cur_one = head;
        int index = 1;
        while (null != cur_one) {
            if (n == index) {
                pre_nth_from_end = nth_from_end;
                nth_from_end = null == nth_from_end ? head : nth_from_end.next;
                cur_one = cur_one.next;
                continue;
            }
            cur_one = cur_one.next;
            index++;
        }

        if (null == pre_nth_from_end) {
            head = head.next;
        } else {
            pre_nth_from_end.next = nth_from_end.next;
        }

        return head;
    }
}
