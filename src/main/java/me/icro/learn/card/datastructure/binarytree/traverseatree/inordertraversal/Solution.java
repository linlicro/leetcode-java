package me.icro.learn.card.datastructure.binarytree.traverseatree.inordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/2/
 *
 *  给定一个二叉树，返回它的中序 遍历。
 *  - 中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树。
 *
 * @author Lin
 * @since 2019-09-10 3:50 PM
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode cur = root;
        while (null != cur || !linkedList.isEmpty()) {
            while (null != cur) {
                linkedList.addFirst(cur);
                cur = cur.left;
            }
            cur = linkedList.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(new Solution().inorderTraversal(root));
    }
}
