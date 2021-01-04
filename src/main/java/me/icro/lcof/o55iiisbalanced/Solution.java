package me.icro.lcof.o55iiisbalanced;

/**
 * @author lin
 * @version v 0.1 2021/1/5
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
}
