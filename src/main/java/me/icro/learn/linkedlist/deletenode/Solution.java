package me.icro.learn.linkedlist.deletenode;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/41/
 *
 * @author Lin
 * @since 2019-05-06 2:09 PM
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (null == node) return;

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
