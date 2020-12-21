package me.icro.lcof.o22getkthfromend;

/**
 * 快慢指针
 * @author lin
 * @version v 0.1 2020/12/21
 **/
public class Solution2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
