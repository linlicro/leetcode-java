package me.icro.learn.tree.constructbinarytree.frominorderandpostorder;

/**
 * 描述:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
 *
 * 解题思路:
 * 前提 ==> 假设二叉树中没有重复的数值的节点
 * 例子:
 *  * inOrder: [1, 2, 3]
 *  * postOrder: [1, 3, 2]
 * 对应的二叉树:
 *   2
 *  / \
 * 1   3
 *
 * 思考过程:
 *  * step1. 找到二叉树的根节点, 是postOrder最后的元素
 *  * step2. 从inOrder中找到该元素(mid为序号), 将inOrder分为两部分, 前面部分是树的左边, 后面部分是树的右边.
 *  * step3. 从postOrder中, 去除最后一个元素(为根节点), 将postOrder也分为两部分:
 *      left. [postOrder_start_index, postOrder_start_index + (mid - inOrder_start_index) - 1]
 *      right. [postOrder_start_index + (mid - inOrder_start_index), postOrder_end_index - 1]
 *      注: (mid - inOrder_start_index) ==> 树的左边元素个数(left_tree_length);
 *          left_tree_length - 1 == postOrder的左侧个数;
 *          postOrder_start_index + left_tree_length == postOrder的右侧开始索引.
 *   * step4. 递归step1, 直至元素遍历完
 *
 * @author Lin
 * @since 2019-04-07 8:00 AM
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (0 == inorder.length || 0 == postorder.length)
            return null;
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    TreeNode buildTree(int[] inorder, int[] postorder, int inStrt, int inEnd, int pStrt, int pEnd) {
        if (inStrt > inEnd) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int mid = inStrt;
        while (inorder[mid] != postorder[pEnd]
                && mid < inEnd) {
            mid++;
        }
        root.right = buildTree(inorder, postorder, mid + 1, inEnd, pStrt + (mid - inStrt), pEnd - 1);
        root.left = buildTree(inorder, postorder, inStrt, mid - 1, pStrt, pStrt + (mid - inStrt) - 1);
        return root;
    }

    public static void main(String[] args) {
        /*           1
                   /   \
                  2      3
                /   \   /  \
               4     5 6    7
                \
                 8
        */
        //int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        //int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        //TreeNode treeNode = new Solution().buildTree(in, post);
        //System.out.println(treeNode);

        int in_2[] = new int[] {1, 2};
        int post_2[] = new int[] {1, 2};
        TreeNode treeNode2 = new Solution().buildTree(in_2, post_2);
        System.out.println(treeNode2);
    }
}
