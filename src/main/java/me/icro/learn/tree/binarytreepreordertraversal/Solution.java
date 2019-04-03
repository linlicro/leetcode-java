package me.icro.learn.tree.binarytreepreordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 练习题 - 前序遍历二叉树
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 * <p>
 * ref 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * @author Lin
 * @since 2019-04-02 10:54 PM
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    /* ref: https://www.geeksforgeeks.org/iterative-preorder-traversal/ */
    public List<Integer> preorderTraversalIter(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        while (!linkedList.isEmpty()) {
            TreeNode cur = linkedList.removeFirst();
            list.add(cur.val);
            if (null != cur.right) linkedList.addFirst(cur.right);
            if (null != cur.left) linkedList.addFirst(cur.left);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(new Solution().preorderTraversal(root));
        System.out.println(new Solution().preorderTraversalIter(root));
    }


}
