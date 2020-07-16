package me.icro.problems.t700searchbst;

/**
 * @author lin
 * @version v 0.1 2020/7/16
 **/
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (null != cur && cur.val != val) {
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}
