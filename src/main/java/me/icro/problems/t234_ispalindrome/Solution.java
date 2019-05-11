package me.icro.problems.t234_ispalindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *  https://leetcode.com/problems/palindrome-linked-list/
 *
 * @author Lin
 * @since 2019-05-11 3:40 PM
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
}
