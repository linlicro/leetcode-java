package me.icro.problems.t230kthsmallest;

/**
 * @author lin
 * @version v 0.1 2020/12/9
 **/
public class Solution {
    int res;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    int rank = 0;
    void traverse(TreeNode node, int k) {
        if (null == node) {
            return;
        }
        traverse(node.left, k);
        rank++;
        if (k == rank) {
            res = node.val;
        }
        traverse(node.right, k);
    }
}
