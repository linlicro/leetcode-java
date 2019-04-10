package me.icro.learn.tree.populatingnextrightpointersineachnode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/
 *
 * 方法1: 参考 level-order算法, {@link me.icro.learn.tree.breadthfirstsearch.Solution}.
 *
 * @author Lin
 * @since 2019-04-10 4:25 PM
 */
public class Solution {
    public Node connect(Node root) {
        if (null == root) return null;

        LinkedList<Node> linkedList = new LinkedList<>();
        List<List<Node>> list = new ArrayList<>();
        List<Node> innerList = new ArrayList<>();
        list.add(innerList);
        linkedList.addFirst(root);
        linkedList.addFirst(null);
        while (!linkedList.isEmpty()) {
            Node cur = linkedList.removeLast();
            if (null == cur) {
                if (!linkedList.isEmpty()) {
                    innerList = new ArrayList<>();
                    list.add(innerList);
                    linkedList.addFirst(null);
                }
                continue;
            }
            innerList.add(cur);
            if (null != cur.left) linkedList.addFirst(cur.left);
            if (null != cur.right) linkedList.addFirst(cur.right);
        }

        for (List<Node> nodes : list) {
            int index = 1;
            while (index < nodes.size()) {
                nodes.get(index - 1).next = nodes.get(index);
                index++;
            }
        }

        return root;
    }

    //Node find_next(Node cur, Node root) {
    //    if ()
    //}

    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2     3
                /  \     \
               4    5     7
        */
        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null, null),
                        new Node(5, null, null, null), null),
                new Node(3,
                        null,
                        new Node(7, null, null, null), null), null);
        new Solution().connect(root);
        System.out.println(root);

        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2     4
                /        \
               3          5
        */
        // in: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":null,"val":2},"next":null,"right":{"$id":"4","left":null,"next":null,"right":{"$id":"5","left":null,"next":null,"right":null,"val":5},"val":3},"val":1}
        // expected: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":null,"right":null,"val":5},"right":null,"val":4},"next":{"$id":"5","left":null,"next":null,"right":{"$ref":"4"},"val":3},"right":null,"val":2},"next":null,"right":{"$ref":"5"},"val":1}
        Node root2 = new Node(1,
                new Node(2,
                        new Node(3, null, null, null),
                        null, null),
                new Node(4,
                        null,
                        new Node(5, null, null, null), null), null);
        new Solution().connect(root2);
        System.out.println(root2);

        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2     3
                /  \     \
               4    5     6
              /            \
             7              8
        */
        // in: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"next":null,"right":null,"val":7},"next":null,"right":null,"val":4},"next":null,"right":{"$id":"5","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"6","left":null,"next":null,"right":{"$id":"7","left":null,"next":null,"right":{"$id":"8","left":null,"next":null,"right":null,"val":8},"val":6},"val":3},"val":1}
        // expected: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":8},"right":null,"val":7},"next":{"$id":"6","left":null,"next":{"$id":"7","left":null,"next":null,"right":{"$ref":"5"},"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"8","left":null,"next":null,"right":{"$ref":"7"},"val":3},"right":{"$ref":"6"},"val":2},"next":null,"right":{"$ref":"8"},"val":1}
    }
}
