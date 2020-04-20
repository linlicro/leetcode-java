package me.icro.leetcodingchallenge2004.bstfrompreorder;

/**
 * @author lin
 * @version v 0.1 2020/4/20
 **/
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (null == preorder) {
            return null;
        }
        return bstFromPreorder(preorder, 0 , preorder.length);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i = start + 1;
        while (i < end) {
            if (preorder[i] > preorder[start]) {
                break;
            }
            i++;
        }
        root.left = bstFromPreorder(preorder, start + 1, i);
        root.right = bstFromPreorder(preorder, i, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode r1 = new Solution().bstFromPreorder(new int[] {
                8,5,1,7,10,12
        });
        System.out.println(r1);
    }
}
