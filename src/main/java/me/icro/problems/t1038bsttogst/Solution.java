package me.icro.problems.t1038bsttogst;

/**
 * @author lin
 * @version v 0.1 2020/12/11
 **/
public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    private void traverse(TreeNode root) {
        if (null == root) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
