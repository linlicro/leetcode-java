package me.icro.problems.t226inverttree;

/**
 * @author lin
 * @version v 0.1 2020/7/14
 **/
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
