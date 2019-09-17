package me.icro.learn.card.datastructure.binarytree.solveproblemsrecursively.maxdepth;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-09-17 4:08 PM
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root)
            return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    public static void main(String[] args) {

    }
}
