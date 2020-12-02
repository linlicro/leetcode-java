package me.icro.problems.t103zigzaglevelorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/2
 **/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        LinkedList<List<TreeNode>> linkedList = new LinkedList<>();
        linkedList.addFirst(Collections.singletonList(root));
        while (!linkedList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nextNodes = new ArrayList<>();
            List<TreeNode> curNodes = linkedList.pop();

            for (TreeNode curNode : curNodes) {
                if (res.size() % 2 == 0) {
                    list.add(curNode.val);
                } else {
                    list.add(0, curNode.val);
                }

                if (null != curNode.left) {
                    nextNodes.add(curNode.left);
                }
                if (null != curNode.right) {
                    nextNodes.add(curNode.right);
                }
            }

            res.add(list);
            if (0 < nextNodes.size()) {
                linkedList.addFirst(nextNodes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
