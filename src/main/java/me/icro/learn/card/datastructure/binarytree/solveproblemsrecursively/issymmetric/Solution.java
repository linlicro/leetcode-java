package me.icro.learn.card.datastructure.binarytree.solveproblemsrecursively.issymmetric;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-09-17 4:16 PM
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root)
            return true;
        return isSymmetricTree(root.left, root.right);
    }

    boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }

        if (null == left) {
            return false;
        }

        if (null == right) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left1 = new TreeNode(2);
        root.right = right1;
        root.left = left1;

        System.out.println(new Solution().isSymmetric(root));
    }
}
