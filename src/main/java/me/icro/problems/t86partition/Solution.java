package me.icro.problems.t86partition;

/**
 * @author lin
 * @version v 0.1 2020/11/23
 **/
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node = new ListNode(0);
        ListNode left = node, right = node, tmpHead = head;
        while (null != tmpHead) {
            if (x > tmpHead.val) {
                ListNode leftNxt = left.next;
                left.next = new ListNode(tmpHead.val);
                left.next.next = leftNxt;
                left = left.next;
            } else {
                right.next = new ListNode(tmpHead.val);
                right = right.next;
            }

            if (null != right.next) {
                right = right.next;
            }
            tmpHead = tmpHead.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().partition());
    }
}
