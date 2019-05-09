package me.icro.learn.linkedlist.removenthfromend;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
 *
 * @author Lin
 * @since 2019-05-06 2:21 PM
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

    public static void main(String[] args) {
        new Solution().removeNthFromEnd(makeListNode(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println("removed 2th from end.");

        new Solution().removeNthFromEnd(makeListNode(new int[]{1}), 1);
        System.out.println("removed 2th from end.");

        new Solution().removeNthFromEnd(makeListNode(new int[]{1}), 1);
        System.out.println("removed 2th from end.");
    }

    static ListNode makeListNode(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode next = new ListNode(vals[i]);
            cur.next = next;
            cur = next;
        }
        return head;
    }
}
