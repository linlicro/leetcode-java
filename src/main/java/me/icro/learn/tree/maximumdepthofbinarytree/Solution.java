package me.icro.learn.tree.maximumdepthofbinarytree;

/**
 * 描述:
 * Given a binary tree, find its maximum depth.
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
 *
 * @author Lin
 * @since 2019-04-05 9:45 PM
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2    3
                /   \    \
               4     5     6
              /
             7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println(new Solution().maxDepth(root));
    }
}
