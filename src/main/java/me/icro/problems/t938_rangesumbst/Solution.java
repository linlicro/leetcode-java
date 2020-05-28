package me.icro.problems.t938_rangesumbst;

import java.util.Stack;

/**
 * 先理解下 什么是二叉搜索树
 *
 * @author lin
 * @version v 0.1 2020/5/28
 **/
public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (null == root) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (null != cur) {
                if (cur.val >= L && cur.val <= R) {
                    res += cur.val;
                }
                if (L < cur.val) {
                    stack.add(cur.left);
                }
                if (R > cur.val) {
                    stack.add(cur.right);
                }
            }
        }
        return res;
    }
}
