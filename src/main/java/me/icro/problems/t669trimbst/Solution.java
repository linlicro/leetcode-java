package me.icro.problems.t669trimbst;

/**
 * @author lin
 * @version v 0.1 2020/7/21
 **/
public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (null == root) {
            return null;
        }
        if (root.val < L) {
            root = trimBST(root.right, L, R);
        } else if (root.val > R) {
            root = trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}
