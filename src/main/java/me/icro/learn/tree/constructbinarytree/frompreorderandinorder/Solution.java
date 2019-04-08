package me.icro.learn.tree.constructbinarytree.frompreorderandinorder;

/**
 * 描述:
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/943/
 * <p>
 * 解题思路:
 * 前提 ==> 假设二叉树中没有重复的数值的节点
 * 例子:
 * * preOrder: [2, 1, 3]
 * * inOrder: [1, 2, 3]
 * 对应的二叉树:
 *  2
 * / \
 * 1   3
 * <p>
 * 思考过程:
 * * step1. preOrder第一个元素为该二叉树的跟节点
 * * step2. 从inOrder中找到该根节点, 将inOrder分为两部分, 前面部分是树的左边, 后面部分是树的右边.
 * * step3. 从preOrder中剔除第一个元素(跟元素), 将preOrder分为两部分:
 * left. [preOrder_start_index + 1, preOrder_start_index + 1 + (mid - inOrder_start_index) - 1]
 * right. [preOrder_start_index + 1 + (mid - inOrder_start_index), preOrder_end_index]
 * 注: (mid - inOrder_start_index) ==> 左边树的元素个数
 * * step4. 递归step1, 直至元素遍历完
 *
 * @author Lin
 * @since 2019-04-08 7:19 PM
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (0 == preorder.length || 0 == inorder.length) return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderStrt, int preorderEnd, int inorderStrt, int inorderEnd) {
        if (inorderStrt > inorderEnd) return null;
        TreeNode root = new TreeNode(preorder[preorderStrt]);
        int mid = inorderStrt;
        while (preorder[preorderStrt] != inorder[mid]
                && mid < inorderEnd) {
            mid++;
        }
        root.left = buildTree(preorder, inorder, preorderStrt + 1, preorderStrt + 1 + (mid - inorderStrt) - 1, inorderStrt, mid - 1);
        root.right = buildTree(preorder, inorder, preorderStrt + 1 + (mid - inorderStrt), preorderEnd, mid + 1, inorderEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{2, 1, 3};
        int[] in = new int[]{1, 2, 3};
        TreeNode treeNode = new Solution().buildTree(pre, in);
        System.out.println(treeNode);

        int[] pre2 = new int[] {3,9,20,15,7};
        int[] in2 = new int[] {9,3,15,20,7};
        TreeNode treeNode1 = new Solution().buildTree(pre2, in2);
        System.out.println(treeNode1);
    }
}
