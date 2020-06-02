package me.icro.problems.t236_lowestcommonancestor;

/**
 * @author lin
 * @version v 0.1 2020/6/2
 **/
public class Solution {
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return false;
        }
        boolean leftSon = dfs(root.left, p, q);
        boolean rightSon = dfs(root.right, p, q);
        if (leftSon && rightSon) {
            ans = root;
        }
        if (root.val == p.val || root.val == q.val) {
            if (leftSon || rightSon) {
                ans = root;
            }
        }
        return leftSon || rightSon || (root.val == p.val || root.val == q.val);
    }
}
