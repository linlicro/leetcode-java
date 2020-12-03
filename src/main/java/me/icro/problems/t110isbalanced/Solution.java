package me.icro.problems.t110isbalanced;

/**
 * @author lin
 * @version v 0.1 2020/12/3
 **/
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (Math.abs(nodeHeight(root.left) - nodeHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int nodeHeight(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        System.out.println(new Solution().isBalanced(root));
    }
}
