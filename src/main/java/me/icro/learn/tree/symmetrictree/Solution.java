package me.icro.learn.tree.symmetrictree;

import java.util.LinkedList;

/**
 * 描述:
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 *
 * @author Lin
 * @since 2019-04-05 10:03 PM
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) return true;
        if (null != root1 && null !=root2 && root1.val == root2.val) {
            return isMirror(root1.left, root2.right)
                    && isMirror(root1.right, root2.left);
        }
        return false;
    }

    public boolean isSymmetricIter(TreeNode root) {
        if (null == root) return true;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root.left);
        linkedList.addFirst(root.right);
        while (!linkedList.isEmpty()) {
            TreeNode tmpLeft = linkedList.removeLast();
            TreeNode tmpRight = linkedList.removeLast();
            if (null == tmpLeft && null == tmpRight)
                continue;
            if (null == tmpLeft && null != tmpRight)
                return false;
            if (null != tmpLeft && null == tmpRight)
                return false;
            if (tmpLeft.val != tmpRight.val)
                return false;

            linkedList.addFirst(tmpLeft.left);
            linkedList.addFirst(tmpRight.right);
            linkedList.addFirst(tmpLeft.right);
            linkedList.addFirst(tmpRight.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        //System.out.println(new Solution().isSymmetric(root));
        System.out.println(new Solution().isSymmetricIter(root));
    }

}
