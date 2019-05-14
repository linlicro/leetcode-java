package me.icro.learn.tree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/50/
 *
 * @author Lin
 * @since 2019-05-14 6:05 PM
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == root) return list;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        linkedList.addFirst(null);
        List<Integer> innerList = new ArrayList<>();
        list.add(innerList);
        while (!linkedList.isEmpty()) {
            TreeNode curr = linkedList.removeLast();
            if (null == curr) {
                if (linkedList.isEmpty()) break;
                innerList = new ArrayList<>();
                list.add(innerList);
                linkedList.addFirst(null);
                continue;
            }
            innerList.add(curr.val);
            if (null != curr.left) linkedList.addFirst(curr.left);
            if (null != curr.right) linkedList.addFirst(curr.right);
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
