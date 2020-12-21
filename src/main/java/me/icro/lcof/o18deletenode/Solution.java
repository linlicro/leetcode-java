package me.icro.lcof.o18deletenode;

/**
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode res = node;
        while (null != node.next) {
            if (val == node.next.val) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return res.next;
    }
}
