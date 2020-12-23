package me.icro.lcof.o32levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/23
 **/
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pollFirst();
            if (null != node.left) {
                linkedList.addLast(node.left);
            }
            if (null != node.right) {
                linkedList.addLast(node.right);
            }
            list.add(node.val);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
