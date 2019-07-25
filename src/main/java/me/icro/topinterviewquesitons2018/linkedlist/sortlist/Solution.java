package me.icro.topinterviewquesitons2018.linkedlist.sortlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/265/linked-list/1147/
 *
 * @author Lin
 * @since 2019-07-25 2:31 PM
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next)
            return head;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(listNode -> listNode.val));
        while (null != head) {
            queue.offer(head);
            head = head.next;
        }
        head = queue.poll();
        ListNode cur = head;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;

        return head;
    }

    /*
        归并
     */
    ListNode sortList2(ListNode head) {
        if (null == head || null == head.next)
            return head;

        ListNode fast = head.next, slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = slow.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList2(head);
        ListNode right = sortList2(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (null != left && null != right) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = null != left ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int[] arr = new int[] {5, 3, 4, 0};
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        // head = new Solution().sortList(head);
        head = new Solution().sortList2(head);
        System.out.println("done");

    }
}
