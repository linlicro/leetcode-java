package me.icro.lcof.o22getkthfromend;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        LinkedList<ListNode> listNodes = new LinkedList<>();
        ListNode node = head;
        while (null != node) {
            listNodes.addFirst(node);
            node = node.next;
        }
        while (!listNodes.isEmpty()) {
            ListNode res = listNodes.pollFirst();
            k--;
            if (0 == k) {
                return res;
            }
        }
        return null;
    }


}
