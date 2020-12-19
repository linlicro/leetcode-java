package me.icro.lcof.o06reverseprint;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/12/19
 **/
public class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListNode node = head;
        while (null != node) {
            linkedList.addFirst(node.val);
            node = node.next;
        }
        int[] res = new int[linkedList.size()];
        int len = linkedList.size();
        for (int i = 0; i < len && !linkedList.isEmpty(); i++) {
            res[i] = linkedList.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(Arrays.toString(new Solution().reversePrint(head)));
    }
}
