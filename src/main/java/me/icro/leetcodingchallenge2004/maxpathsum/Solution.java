package me.icro.leetcodingchallenge2004.maxpathsum;

import java.util.ArrayList;

/**
 * @author lin
 * @version v 0.1 2020/4/29
 **/
public class Solution {
    public int maxPathSum(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(Integer.MIN_VALUE);
        helper(root, res);
        return res.get(0);
    }


    private int helper(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int cur = root.val + (Math.max(left, 0)) + (Math.max(right, 0));
        if (cur > res.get(0)) {
            res.set(0, cur);
        }
        return root.val + Math.max(left, Math.max(right, 0));
    }
}
