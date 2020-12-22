package me.icro.lcof.o27mirrortree;

/**
 * @author lin
 * @version v 0.1 2020/12/22
 **/
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorTree(root.right);
        node.right = mirrorTree(root.left);
        return node;
    }
}
