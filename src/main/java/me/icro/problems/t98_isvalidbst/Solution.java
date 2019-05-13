package me.icro.problems.t98_isvalidbst;

/**
 * 描述:
 *  https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author Lin
 * @since 2019-05-13 10:07 AM
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return bstUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean bstUtil(TreeNode node, long min, long max) {
        if (null == node) return true;

        if (node.val <= min || node.val >= max) return false;

        return bstUtil(node.left, min, node.val) && bstUtil(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2    3
                /   \    \
               4     5     6
              /
             7
        */
        //TreeNode root = new TreeNode(4);
        //root.left = new TreeNode(3);
        //root.right = new TreeNode(5);
        //root.left.left = new TreeNode(2);
        //System.out.println(new Solution().isValidBST(root));

        TreeNode root1 = new TreeNode(Integer.MIN_VALUE);
        root1.left = new TreeNode(Integer.MIN_VALUE);
        System.out.println(new Solution().isValidBST(root1));

    }
}
