package me.icro.learn.card.datastructure.binarytree.solveproblemsrecursively.haspathsum;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/14/
 *
 * @author Lin
 * @since 2019-09-17 6:16 PM
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(8);
        root.left = left1;
        root.right = right1;
        TreeNode left1_left = new TreeNode(11);
        left1.left = left1_left;
        TreeNode left1_left_left = new TreeNode(7);
        TreeNode left1_left_right = new TreeNode(2);
        left1_left.left = left1_left_left;
        left1_left.right = left1_left_right;
        TreeNode right1_left = new TreeNode(13);
        TreeNode right1_right = new TreeNode(4);
        right1.left = right1_left;
        right1.right = right1_right;

        System.out.println(new Solution().hasPathSum(root, 22));
    }
}
