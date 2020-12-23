package me.icro.lcof.o32iiilevelorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/23
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        while (!linkedList.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int index = linkedList.size() - 1; index >= 0; index--) {
                TreeNode node = linkedList.pollLast();
                if ((res.size() & 1) == 1) {
                    tmp.addFirst(node.val);
                } else {
                    tmp.addLast(node.val);
                }
                if (null != node.left) {
                    linkedList.addFirst(node.left);
                }
                if (null != node.right) {
                    linkedList.addFirst(node.right);
                }
            }

            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Solution().levelOrder(root));
    }
}
