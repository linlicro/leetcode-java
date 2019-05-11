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
}
