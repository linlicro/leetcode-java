package me.icro.learn.tree.issymmetric;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/49/
 *
 * @author Lin
 * @since 2019-05-14 7:17 AM
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode left, TreeNode right) {
        if (null == left && null == right)
            return true;
        if (null != left && null != right && left.val == right.val) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;
    }
}
