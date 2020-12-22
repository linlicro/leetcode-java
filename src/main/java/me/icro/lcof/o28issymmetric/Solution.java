package me.icro.lcof.o28issymmetric;

/**
 * @author lin
 * @version v 0.1 2020/12/22
 **/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
