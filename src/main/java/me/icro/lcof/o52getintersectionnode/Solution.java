package me.icro.lcof.o52getintersectionnode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2020/12/30
 **/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (null != nodeA || null != nodeB) {
            if (null != nodeA) {
                if (visited.contains(nodeA)) {
                    return nodeA;
                }
                visited.add(nodeA);
                nodeA = nodeA.next;
            }
            if (null != nodeB) {
                if (visited.contains(nodeB)) {
                    return nodeB;
                }
                visited.add(nodeB);
                nodeB = nodeB.next;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = null != nodeA ? nodeA.next : headB;
            nodeB = null != nodeB ? nodeB.next : headA;
        }
        return nodeA;
    }
}
