package me.icro.learn.tree.binarytreepostordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 练习题 - 后序遍历二叉树
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
 *
 * @author Lin
 * @since 2019-04-03 3:39 PM
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (null != root.left) list.addAll(postorderTraversal(root.left));
        if (null != root.right) list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    /* ref: https://www.geeksforgeeks.org/iterative-postorder-traversal/ */
    public List<Integer> postorderTraversalIter(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        // todo
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(new Solution().postorderTraversal(root));
        System.out.println(new Solution().postorderTraversalIter(root));
    }
}
