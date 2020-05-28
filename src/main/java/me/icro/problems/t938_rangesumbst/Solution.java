package me.icro.problems.t938_rangesumbst;

/**
 * 先理解下 什么是二叉搜索树
 *
 * @author lin
 * @version v 0.1 2020/5/28
 **/
public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int res = 0;
        if (null == root) {
            return res;
        }
        res += (root.val >= L && root.val <= R) ? root.val : 0;
        if (root.val < L) {
            res += rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            res += rangeSumBST(root.left, L, R);
        } else {
            res = res + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
        return res;
    }
}
