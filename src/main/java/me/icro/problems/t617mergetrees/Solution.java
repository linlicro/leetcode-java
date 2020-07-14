package me.icro.problems.t617mergetrees;

/**
 * @author lin
 * @version v 0.1 2020/7/14
 **/
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }
        TreeNode root = new TreeNode();
        if (null == t1) {
            root.val = t2.val;
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        } else if (null == t2) {
            root.val = t1.val;
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        } else {
            root.val = t1.val + t2.val;
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }


}
