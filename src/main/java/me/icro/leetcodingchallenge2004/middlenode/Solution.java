package me.icro.leetcodingchallenge2004.middlenode;

/**
 * @author lin
 * @version v 0.1 2020/4/8
 **/
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        while (null != second) {
            first = first.next;
            second = null == second.next ? null : second.next.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(new Solution().middleNode(listNode1));
    }
}
