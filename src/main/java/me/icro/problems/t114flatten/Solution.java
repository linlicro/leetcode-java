package me.icro.problems.t114flatten;

/**
 * @author lin
 * @version v 0.1 2020/10/9
 **/
public class Solution {
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        // 拉平左右分支
        flatten(root.left);
        flatten(root.right);

        // 移动左右分支
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (null != p.right) {
            p = p.right;
        }
        p.right = right;
    }
}
