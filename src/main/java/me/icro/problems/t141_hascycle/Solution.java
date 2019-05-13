package me.icro.problems.t141_hascycle;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *  https://leetcode.com/problems/linked-list-cycle/
 *
 * @author Lin
 * @since 2019-05-12 7:47 AM
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

    /*
        双指针: 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。慢指针每次移动一步，而快指针每次移动两步。
     */
    public boolean hasCycle2(ListNode head) {
        if (null == head || null == head.next) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (null == fast || null == fast.next) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
