package me.icro.problems.t95generatetrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2021/1/6
 **/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (1 > n) {
            return res;
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            return Collections.singletonList(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
