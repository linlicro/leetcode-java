package me.icro.problems.t701insertintobst;

/**
 * @author lin
 * @version v 0.1 2020/12/10
 **/
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
