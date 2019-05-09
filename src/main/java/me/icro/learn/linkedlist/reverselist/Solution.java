package me.icro.learn.linkedlist.reverselist;

import java.util.LinkedList;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 *
 * @author Lin
 * @since 2019-05-09 3:14 PM
 */
public class Solution {

    /*
    保存至栈, 再取出来重连接
     */
    public ListNode reverseList(ListNode head) {

        if (null == head) return null;

        LinkedList<ListNode> listNodes = new LinkedList<>();
        ListNode cur_one = head;
        while (null != cur_one) {
            listNodes.addFirst(cur_one);
            cur_one = cur_one.next;
        }

        head = listNodes.removeFirst();
        cur_one = head;
        while (!listNodes.isEmpty()) {
            cur_one.next = listNodes.removeFirst();
            cur_one = cur_one.next;
        }

        cur_one.next = null;

        return head;
    }

    /*
    迭代
    在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /*
    递归版本，其关键在于反向工作。假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？

     */
    public ListNode reverseList3(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode res = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseList2(makeListNode(new int[] {1, 2, 3, 4})));
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
