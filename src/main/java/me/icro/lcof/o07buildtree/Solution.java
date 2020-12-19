package me.icro.lcof.o07buildtree;

/**
 * @author lin
 * @version v 0.1 2020/12/19
 **/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pStart]);
        int c = calcLeftTreeNoteCount(preorder[pStart], inorder, iStart, iEnd);
        node.left = helper(preorder, pStart + 1, pStart + c, inorder, iStart, iStart + c - 1);
        node.right = helper(preorder, pStart + 1 + c, pEnd, inorder, iStart + c + 1, iEnd);
        return node;
    }

    private int calcLeftTreeNoteCount(int val, int[] inorder, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (val == inorder[i]) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
