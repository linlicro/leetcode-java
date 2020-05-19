package me.icro.problems.t24_swappairs;

/**
 * @author lin
 * @version v 0.1 2020/5/19
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1. 先交换 前两个，即 2 -> 1
        // 2. 后面一个指向 剩余链表的交换结果，即 2 -> 1 -> (剩余链表交换结果)
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        System.out.println(new Solution().swapPairs(node1));
    }
}
