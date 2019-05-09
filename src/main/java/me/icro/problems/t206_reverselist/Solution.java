package me.icro.problems.t206_reverselist;

import java.util.LinkedList;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-09 4:16 PM
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
}
