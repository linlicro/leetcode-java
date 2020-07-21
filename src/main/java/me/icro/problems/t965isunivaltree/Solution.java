package me.icro.problems.t965isunivaltree;

/**
 * @author lin
 * @version v 0.1 2020/7/21
 **/
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (null == root) {
            return true;
        }
        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if (null == root) {
            return true;
        }
        if (val != root.val) {
            return false;
        }
        return helper(root.left, val) && helper(root.right, val);
    }
}
