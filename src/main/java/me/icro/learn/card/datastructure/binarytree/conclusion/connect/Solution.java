package me.icro.learn.card.datastructure.binarytree.conclusion.connect;

import java.util.LinkedList;

/**
 * 描述:
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/17/
 *
 * @author Lin
 * @since 2019-09-27 4:31 PM
 */
public class Solution {
    public Node connect(Node root) {
        if (null == root)
            return null;
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        linkedList.addLast(null);
        while (!linkedList.isEmpty()) {
            Node cur = linkedList.pollFirst();
            if (null == cur) {
                if (linkedList.isEmpty()) {
                    break;
                }
                linkedList.addLast(null);
                continue;
            }
            cur.next = linkedList.peekFirst();
            if (null != cur.left)
                linkedList.addLast(cur.left);
            if (null != cur.right)
                linkedList.addLast(cur.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        root.left = new Node(2,
                new Node(4, null, null, null),
                new Node(5, null, null, null), null);
        root.right = new Node(3,
                new Node(6, null, null, null),
                new Node(7, null, null, null), null);
        new Solution().connect(root);
    }
}
