package me.icro.learn.tree.serializeanddeserializebinarytree;

import java.util.*;

/**
 * 描述:
 *  https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
 *
 *
 * @author Lin
 * @since 2019-04-17 10:12 AM
 */
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) return null;
        return String.join(",", preorder(root));
    }

    List<String> preorder(TreeNode root) {
        if (null == root) return Collections.singletonList(null);
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(root.val));
        list.addAll(preorder(root.left));
        list.addAll(preorder(root.right));
        return list;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || 0 == data.length()) return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return depreorder(queue);
    }

    TreeNode depreorder(Queue<String> queue) {
        String val = queue.poll();
        if (null == val || "null".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = depreorder(queue);
        root.right = depreorder(queue);
        return root;
    }

    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2    3
                /   \    \
               4     5     6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        String str = new Solution().serialize(root);
        TreeNode treeNode = new Solution().deserialize(str);
        System.out.println(treeNode);
    }
}
