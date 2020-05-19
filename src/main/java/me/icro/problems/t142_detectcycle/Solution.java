package me.icro.problems.t142_detectcycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2020/5/19
 **/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // HashSet 解法
        // 遍历 并存储至HashSet，当再次出现HashMap中的 Node时，该节点就是 入环的第一个节点
//        Set<ListNode> set = new HashSet<>(64);
//        while (null != head) {
//            if (set.contains(head)) {
//                return head;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return null;

        // Floyd 算法
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
