package me.icro.problems.t111_mindepth;

/**
 * @author lin
 * @version v 0.1 2020/5/30
 **/
public class Solution {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int curDepth;
        if (null == root.left) {
            curDepth = minDepth(root.right) + 1;
        } else if (null == root.right) {
            curDepth = minDepth(root.left) + 1;
        } else {
            curDepth = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return curDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new Solution().minDepth(root));
    }
}
