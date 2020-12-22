package me.icro.lcof.o24reverselist;

/**
 * @author lin
 * @version v 0.1 2020/12/22
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
