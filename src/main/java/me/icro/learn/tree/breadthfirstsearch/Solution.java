package me.icro.learn.tree.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * readth-First Search is an algorithm to traverse or search in data structures like a tree or a graph.
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
 *
 * @author Lin
 * @since 2019-04-04 2:39 PM
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        linkedList.addFirst(null); // a delimiter
        List<Integer> innerList = new ArrayList<>();
        list.add(innerList);
        while (!linkedList.isEmpty()) {
            TreeNode cur = linkedList.removeLast();
            if (null == cur) {
                if (!linkedList.isEmpty()) {
                    innerList = new ArrayList<>();
                    list.add(innerList);
                    linkedList.addFirst(null); // a delimiter
                }
                continue;
            }
            innerList.add(cur.val);
            if (null != cur.left) linkedList.addFirst(cur.left);
            if (null != cur.right) linkedList.addFirst(cur.right);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder(null));
        System.out.println(new Solution().levelOrder(new TreeNode(1)));
        // Let us create binary tree shown in above diagram
       /*            1
                   /  \
                  2    3
                /   \    \
               4     5     6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(new Solution().levelOrder(root));
    }


}
