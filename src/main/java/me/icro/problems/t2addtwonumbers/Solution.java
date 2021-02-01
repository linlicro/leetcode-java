package me.icro.problems.t2addtwonumbers;

/**
 * @author lin
 * @version v 0.1 2021/2/1
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode node1 = l1, node2 = l2, node = res;
        boolean needPlusOne = false;
        while (null != node1 || null != node2) {
            int val1 = null == node1 ? 0 : node1.val;
            int val2 = null == node2 ? 0 : node2.val;

            node1 = null == node1 ? null : node1.next;
            node2 = null == node2 ? null : node2.next;

            int sum = val1 + val2 + (needPlusOne ? 1 : 0);
            needPlusOne = sum >= 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        if (needPlusOne) {
            node.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(
                2,
                new ListNode(
                        4,
                        new ListNode(3)
                )
        );
        ListNode l2 = null;
        new Solution().addTwoNumbers(l1, null);


    }
}
