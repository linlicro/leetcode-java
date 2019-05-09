package me.icro.learn.linkedlist.reverselist;

import java.util.LinkedList;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 *
 * @author Lin
 * @since 2019-05-09 3:14 PM
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

        if (null == head) return null;

        LinkedList<ListNode> listNodes = new LinkedList<>();
        ListNode cur_one = head;
        while (null != cur_one) {
            listNodes.addFirst(cur_one);
            cur_one = cur_one.next;
        }

        head = listNodes.removeFirst();
        cur_one = head;
        while (!listNodes.isEmpty()) {
            cur_one.next = listNodes.removeFirst();
            cur_one = cur_one.next;
        }

        cur_one.next = null;

        return head;
    }

    public ListNode reverseList2(ListNode head) {
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

    public static void main(String[] args) {
        System.out.println(new Solution().reverseList2(makeListNode(new int[] {1, 2, 3, 4})));
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
