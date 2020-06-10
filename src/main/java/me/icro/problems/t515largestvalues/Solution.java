package me.icro.problems.t515largestvalues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/6/10
 **/
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = deque.pollLast();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    deque.addFirst(cur.left);
                }
                if (cur.right != null) {
                    deque.addFirst(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left.setLeft(new TreeNode(5));
        root.left.setRight(new TreeNode(3));
        root.right.setRight(new TreeNode(9));
        System.out.println(new Solution().largestValues(root));
    }
}
