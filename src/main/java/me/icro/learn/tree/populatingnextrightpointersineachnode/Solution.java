package me.icro.learn.tree.populatingnextrightpointersineachnode;

/**
 * 描述:
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
 *
 * @author Lin
 * @since 2019-04-10 9:52 AM
 */
public class Solution {
    public Node connect(Node root) {
        if (null == root) return null;
        if (null == root.left || null == root.right) return root;
        root.left.next = root.right;
        if (null != root.next)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2     3
                /  \   / \
               4    5 6   7
        */
        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null, null),
                        new Node(5, null, null, null), null),
                new Node(3,
                        new Node(6, null, null, null),
                        new Node(7, null, null, null), null), null);
        new Solution().connect(root);
        System.out.println(root);
    }
}
