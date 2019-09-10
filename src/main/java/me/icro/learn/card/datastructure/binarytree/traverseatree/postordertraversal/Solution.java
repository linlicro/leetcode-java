package me.icro.learn.card.datastructure.binarytree.traverseatree.postordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/3/
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * - 后序遍历是先遍历左子树，然后遍历右子树，最后访问树的根节点。
 *
 * @author Lin
 * @since 2019-09-10 4:32 PM
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root)
            return list;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode cur = linkedList.pop();
            list.add(0, cur.val);
            if (null != cur.left) {
                linkedList.addFirst(cur.left);
            }
            if (null != cur.right) {
                linkedList.addFirst(cur.right);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(new Solution().postorderTraversal(root));
    }

}
