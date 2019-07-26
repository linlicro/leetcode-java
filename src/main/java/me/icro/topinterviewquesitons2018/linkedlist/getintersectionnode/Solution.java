package me.icro.topinterviewquesitons2018.linkedlist.getintersectionnode;

import java.util.HashMap;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/265/linked-list/1148/
 *
 * @author Lin
 * @since 2019-07-26 10:27 AM
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB)
            return null;

        HashMap<ListNode, Integer> map = new HashMap<>();
        while (null != headA || null != headB) {

            if (null != headA) {
                if (map.containsKey(headA))
                    return headA;
                map.put(headA, headA.val);
                headA = headA.next;
            }
            if (null != headB) {
                if (map.containsKey(headB))
                    return headB;
                map.put(headB, headB.val);
                headB = headB.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
