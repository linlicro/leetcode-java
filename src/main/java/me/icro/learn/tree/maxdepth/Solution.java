package me.icro.learn.tree.maxdepth;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
 *
 * @author Lin
 * @since 2019-05-13 7:56 AM
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return  Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
