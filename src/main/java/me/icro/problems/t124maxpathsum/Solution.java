package me.icro.problems.t124maxpathsum;

/**
 * @author lin
 * @version v 0.1 2021/1/6
 **/
public class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        int lmr = left + node.val + right;
        res = Math.max(res, lmr);

        return Math.max(left + node.val, node.val + right);
    }
}
