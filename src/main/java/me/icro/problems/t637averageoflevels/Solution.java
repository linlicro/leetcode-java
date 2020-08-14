package me.icro.problems.t637averageoflevels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/8/14
 **/
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (null != root) {
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            linkedList.addFirst(root);
            while (!linkedList.isEmpty()) {
                int size = linkedList.size();
                long curSum = 0;
                int tmpCurSize = size;
                while (--size >= 0) {
                    TreeNode cur = linkedList.pollLast();
                    curSum += cur.val;
                    if (null != cur.left) {
                        linkedList.addFirst(cur.left);
                    }
                    if (null != cur.right) {
                        linkedList.addFirst(cur.right);
                    }
                }
                list.add(((double) curSum) / tmpCurSize);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        System.out.println(new Solution().averageOfLevels(root));

        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        root.left = new TreeNode(Integer.MAX_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        System.out.println(new Solution().averageOfLevels(root));
    }
}
