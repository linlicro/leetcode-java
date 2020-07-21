package me.icro.problems.t897increasingbst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/7/21
 **/
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 中序遍历
        inorder(root, list);
        TreeNode node = new TreeNode(0);
        TreeNode cur = node;
        for (Integer integer : list) {
            cur.right = new TreeNode(integer);
            cur = cur.right;
        }
        return node.right;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


}
