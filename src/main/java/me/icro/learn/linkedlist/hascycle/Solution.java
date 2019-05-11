package me.icro.learn.linkedlist.hascycle;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
 *
 * @author Lin
 * @since 2019-05-12 7:30 AM
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) return false;
        Map<ListNode, Integer> val_pos_map = new HashMap<>();
        int index = 0;
        while (null != head) {
            if (val_pos_map.containsKey(head))
                return true;
            val_pos_map.put(head, index);
            head = head.next;
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(new Solution().hasCycle(listNode1));
    }
}
