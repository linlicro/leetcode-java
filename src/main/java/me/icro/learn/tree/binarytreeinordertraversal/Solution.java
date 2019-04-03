package me.icro.learn.tree.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 练习题 - 中序遍历二叉树
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/
 *
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * @author Lin
 * @since 2019-04-03 3:22 PM
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (null != root.left) {
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
        } else list.add(root.val);
        if (null != root.right) list.addAll(inorderTraversal(root.right));
        return list;
    }

    /* ref: https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/ */
    public List<Integer> inorderTraversalIter(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode cur = root;
        while (null != cur || !linkedList.isEmpty()) {
            while (null != cur) {
                linkedList.addFirst(cur);
                cur = cur.left;
            }
            cur = linkedList.removeFirst();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(new Solution().inorderTraversal(root));
        System.out.println(new Solution().inorderTraversalIter(root));
    }
}
