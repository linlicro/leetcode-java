package me.icro.lcof.o25mergetwolists;

/**
 * @author lin
 * @version v 0.1 2020/12/22
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode res = node;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (null != node1 && null != node2) {
            if (node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }
        while (null != node1) {
            node.next = node1;
            node1 = node1.next;
            node = node.next;
        }
        while (null != node2) {
            node.next = node2;
            node2 = node2.next;
            node = node.next;
        }
        return res.next;
    }
}
