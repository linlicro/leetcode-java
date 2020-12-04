package me.icro.problems.t129sumnumbers;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/12/4
 **/
public class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (null == root) {
            return sum;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pollFirst();
            if (null != node.left) {
                node.left.val += node.val * 10;
                linkedList.addLast(node.left);
            }
            if (null != node.right) {
                node.right.val += node.val * 10;
                linkedList.addLast(node.right);
            }
            if (null == node.left && null == node.right) {
                sum += node.val;
            }
        }
        return sum;
    }
}
