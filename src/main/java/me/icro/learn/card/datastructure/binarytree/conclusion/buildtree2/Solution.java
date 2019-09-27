package me.icro.learn.card.datastructure.binarytree.conclusion.buildtree2;

/**
 * 描述:
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/16/
 *
 * @author Lin
 * @since 2019-09-25 4:47 PM
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (null == inorder || 0 == inorder.length) {
            return null;
        }

        if (1 == inorder.length) {
            return new TreeNode(inorder[0]);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorder_left_index, int preorder_right_index, int inorder_left_index, int inorder_right_index) {
        if (preorder_left_index > preorder_right_index) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorder_left_index]);
        if (inorder_left_index == inorder_right_index)
            return root;

        int inorder_root_index = 0;
        for (int i = inorder_left_index; i <= inorder_right_index; i++) {
            if (inorder[i] == root.val) {
                inorder_root_index = i;
                break;
            }
        }

        int left_tree_preorder_left_index = preorder_left_index + 1;
        int left_tree_preorder_right_index = preorder_left_index + (inorder_root_index - inorder_left_index);
        int left_tree_inorder_left_index = inorder_left_index;
        int left_tree_inorder_right_index = inorder_left_index + (inorder_root_index - inorder_left_index - 1);


        int right_tree_preorder_left_index = left_tree_preorder_right_index + 1;
        int right_tree_preorder_right_index = preorder_right_index;
        int right_tree_inorder_left_index = inorder_root_index + 1;
        int right_tree_inorder_right_index = inorder_right_index;

        root.left = buildTree(preorder, inorder, left_tree_preorder_left_index, left_tree_preorder_right_index, left_tree_inorder_left_index, left_tree_inorder_right_index);
        root.right = buildTree(preorder, inorder, right_tree_preorder_left_index, right_tree_preorder_right_index, right_tree_inorder_left_index, right_tree_inorder_right_index);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
