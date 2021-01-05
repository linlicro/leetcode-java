package me.icro.problems.t102levelorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2021/1/6
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        LinkedList<List<TreeNode>> queue = new LinkedList<>();
        queue.addFirst(Collections.singletonList(root));
        while (!queue.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            List<TreeNode> curLevelNodes = queue.pollLast();
            List<TreeNode> nxtLevelNodes = new ArrayList<>();
            for (TreeNode node : curLevelNodes) {
                if (null != node.left) {
                    nxtLevelNodes.add(node.left);
                }
                if (null != node.right) {
                    nxtLevelNodes.add(node.right);
                }
                vals.add(node.val);
            }
            if (0 < nxtLevelNodes.size()) {
                queue.addFirst(nxtLevelNodes);
            }

            res.add(vals);
        }
        return res;
    }
}
