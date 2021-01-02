package me.icro.lcof.o68iilowestcommonancestor;

/**
 * @author lin
 * @version v 0.1 2021/1/2
 **/
public class Solution {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (null == node) {
            return false;
        }
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        // p 和 q 在 root 的子树中，且分列 rootroot 的 异侧 即分别在左、右子树中
        if (left && right) {
            ans = node;
        }
        // p=root ，且 q 在 root 的左或右子树中; q=root ，且 p 在 root 的左或右子树中；
        if (node == p || node == q) {
            if (left || right) {
                ans = node;
            }
        }
        return left || right || (node == p || node == q);
    }
}
