package me.icro.learn.tree.pathsum;

/**
 * 描述:
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
 *
 * @author Lin
 * @since 2019-04-06 2:28 PM
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) return 0 == sum;
        int subSum = sum - root.val;
        if (0 == subSum
                && null == root.left
                && null == root.right)
            return true;
        boolean ans = false;
        if (null != root.left)
            ans = (ans || hasPathSum(root.left, subSum));
        if (null != root.right)
            ans = (ans || hasPathSum(root.right, subSum));

        return ans;
    }

    public static void main(String[] args) {
        int sum = 22;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        System.out.println(new Solution().hasPathSum(root, sum));

        TreeNode root_null = null;
        TreeNode root2 = new TreeNode(0);
        System.out.println(new Solution().hasPathSum(root2, 0));
    }
}
