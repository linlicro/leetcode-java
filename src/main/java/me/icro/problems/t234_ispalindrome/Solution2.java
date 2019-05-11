package me.icro.problems.t234_ispalindrome;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-11 3:41 PM
 */
public class Solution2 {

    public boolean isPalindrome(ListNode head) {
        /*
        快慢指针
         */
        if (null == head || null == head.next) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow.next);
        while (null != slow) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome(makeListNode(new int[] {0, 0})));
    }

    static ListNode makeListNode(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode next = new ListNode(vals[i]);
            cur.next = next;
            cur = next;
        }
        return head;
    }
}
