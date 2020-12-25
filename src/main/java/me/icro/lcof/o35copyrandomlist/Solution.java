package me.icro.lcof.o35copyrandomlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/12/24
 **/
public class Solution {
    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (null != cur) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(null != cur) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.random = head.next;
//        head.next.random = head.next;
//        System.out.println(new Solution().copyRandomList(head));
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        System.out.println(new Solution().copyRandomList(head));
    }
}
