package me.icro.problems.t237_deletenode;

/**
 * 描述:
 *  https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * @author Lin
 * @since 2019-05-06 2:19 PM
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (null == node) return;

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
