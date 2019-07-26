package me.icro.topinterviewquesitons2018.linkedlist.oddevenlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-07-26 11:39 AM
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) return head;

        List<ListNode> list = new ArrayList<>();
        while (null != head) {
            list.add(head);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).next = ((i + 2) < list.size()) ? list.get(i + 2) : null;
        }
        list.get(list.size() - (list.size() % 2 == 0 ? 2 : 1)).next = list.get(1);
        return list.get(0);
    }
}
