package me.icro.learn.card.datastructure.binarytree.traverseatree.preordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/1/
 *
 *  给定一个二叉树，返回它的 前序 遍历。
 *  - 前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树。
 *
 * @author Lin
 * @since 2019-09-10 3:37 PM
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (null == root)
            return list;

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        while (!linkedList.isEmpty()) {
            TreeNode cur = linkedList.pop();
            list.add(cur.val);
            if (null != cur.right) {
                linkedList.addFirst(cur.right);
            }
            if (null != cur.left) {
                linkedList.addFirst(cur.left);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);
        root.right = right1;
        root.left = left1;
        right1.left = left2;
        right1.right = right2;
        System.out.println(new Solution().preorderTraversal(root));
    }
}
