package me.icro.problems.t113pathsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/1
 **/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        find(root, sum, new ArrayList<>());
        return res;
    }

    private void find(TreeNode cur, int sum, List<Integer> list) {
        if (null == cur) {
            return;
        }

        list.add(cur.val);
        if (cur.val == sum && null == cur.left && null == cur.right) {
            res.add(new ArrayList<>(list));
        } else {
            find(cur.left, sum - cur.val, list);
            find(cur.right, sum - cur.val, list);
        }

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().pathSum(root, 22));

        root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        System.out.println(new Solution().pathSum(root, -5));
    }
}
