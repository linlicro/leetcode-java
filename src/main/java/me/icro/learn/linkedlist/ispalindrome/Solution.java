package me.icro.learn.linkedlist.ispalindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/45/
 *
 * @author Lin
 * @since 2019-05-11 3:12 PM
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) return true;
        List<Integer> list = new ArrayList<>();
        while (null != head) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i< list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 -i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().isPalindrome(null));
        //System.out.println(new Solution().isPalindrome(makeListNode(new int[] {1, 2})));
        //System.out.println(new Solution().isPalindrome(makeListNode(new int[] {1, 2, 2, 1})));
        System.out.println(new Solution().isPalindrome(makeListNode(new int[] {-129, -129})));
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
