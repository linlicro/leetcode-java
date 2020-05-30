package me.icro.problems.t104_maxdepth;

import me.icro.problems.t98_isvalidbst.Solution2;

/**
 * @author lin
 * @version v 0.1 2020/5/30
 **/
public class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(10);
        System.out.println(new Solution().maxDepth(root));
    }
}
