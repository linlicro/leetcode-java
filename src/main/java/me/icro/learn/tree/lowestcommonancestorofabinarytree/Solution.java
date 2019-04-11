package me.icro.learn.tree.lowestcommonancestorofabinarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
 * <p>
 * 思路:
 *
 * @author Lin
 * @since 2019-04-11 3:50 PM
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) return null;
        List<TreeNode> path_p = new ArrayList<>();
        List<TreeNode> path_q = new ArrayList<>();
        if (!findPath(root, p.val, path_p)) return null;
        if (!findPath(root, q.val, path_q)) return null;
        int i = 0;
        for (; i< path_p.size() && i < path_q.size(); i++) {
            if (!path_p.get(i).equals(path_q.get(i))) {
                return path_p.get(i - 1);
            }
        }
        return path_p.get(i - 1);
    }

    boolean findPath(TreeNode node, int n, List<TreeNode> path) {
        if (null == node) return false;
        path.add(node);
        if (n == node.val) return true;

        if (null != node.left && findPath(node.left, n, path))
            return true;

        if (null != node.right && findPath(node.right, n, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2     3
                /  \   / \
               4    5 6   7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5): " + new Solution().lowestCommonAncestor(root, root.left.left, root.left.right).val);
        System.out.println("LCA(4, 6): " + new Solution().lowestCommonAncestor(root, root.left.left, root.right.left).val);
        System.out.println("LCA(3, 4): " + new Solution().lowestCommonAncestor(root, root.right, root.left.left).val);
        System.out.println("LCA(2, 4): " + new Solution().lowestCommonAncestor(root, root.left, root.left.left).val);
    }

}
