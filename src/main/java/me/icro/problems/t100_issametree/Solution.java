package me.icro.problems.t100_issametree;

import java.util.Objects;

/**
 * @author lin
 * @version v 0.1 2020/5/28
 **/
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p || null == q) {
            return Objects.isNull(p) && Objects.isNull(q);
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}
