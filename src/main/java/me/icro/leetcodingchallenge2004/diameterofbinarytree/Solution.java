package me.icro.leetcodingchallenge2004.diameterofbinarytree;

/**
 * @author lin
 * @version v 0.1 2020/4/11
 **/
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int diameter = maxDepth(root.left) + maxDepth(root.right);
        int leafDiameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(diameter, leafDiameter);
    }

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left_depth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(left_depth, rightDepth) + 1;
    }

    public static void main(String[] args) {

    }
}
