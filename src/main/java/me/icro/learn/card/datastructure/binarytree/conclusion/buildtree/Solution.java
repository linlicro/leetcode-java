package me.icro.learn.card.datastructure.binarytree.conclusion.buildtree;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/15/
 *
 * @author Lin
 * @since 2019-09-24 6:37 PM
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (null == inorder || 0 == inorder.length) {
            return null;
        }

        if (1 == inorder.length) {
            return new TreeNode(inorder[0]);
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inorder_left_index, int inorder_right_index, int postorder_left_index, int postorder_right_index) {
        if (inorder_left_index > inorder_right_index) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder_right_index]);
        if (inorder_left_index == inorder_right_index)
            return root;

        int inorder_root_index = 0;
        for (int i = inorder_left_index; i <= inorder_right_index; i++) {
            if (inorder[i] == root.val) {
                inorder_root_index = i;
                break;
            }
        }

        int left_tree_inorder_left_index = inorder_left_index;
        int left_tree_inorder_right_index = inorder_root_index - 1;
        int left_tree_postorder_left_index = postorder_left_index;
        int left_tree_postorder_right_index = postorder_left_index + (inorder_root_index - inorder_left_index - 1);

        int right_tree_inorder_left_index = inorder_root_index + 1;
        int right_tree_inorder_right_index = inorder_right_index;
        int right_tree_postorder_left_index = postorder_left_index + (inorder_root_index - inorder_left_index);
        int right_tree_postorder_right_index = postorder_right_index - 1;


        root.left = buildTree(inorder, postorder, left_tree_inorder_left_index, left_tree_inorder_right_index, left_tree_postorder_left_index, left_tree_postorder_right_index);
        root.right = buildTree(inorder, postorder, right_tree_inorder_left_index, right_tree_inorder_right_index, right_tree_postorder_left_index, right_tree_postorder_right_index);
        return root;
    }

    public static void main(String[] args) {
        //new Solution().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        //new Solution().buildTree(new int[]{3, 2, 1}, new int[]{3, 2, 1});
        new Solution().buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
    }
}
