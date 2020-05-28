package me.icro.problems.t107_levelorderbottom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/5/28
 **/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, lists, 0);
        Collections.reverse(lists);
        return lists;
    }

    void helper(TreeNode root, List<List<Integer>> res, Integer level) {
        if (null == root) {
            return;
        }

        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left = new TreeNode(7);

        System.out.println(new Solution().levelOrderBottom(root));
    }
}
