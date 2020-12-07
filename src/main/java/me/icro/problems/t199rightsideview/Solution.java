package me.icro.problems.t199rightsideview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/7
 **/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        LinkedList<List<TreeNode>> linkedList = new LinkedList<>();
        linkedList.addFirst(Collections.singletonList(root));
        {
            while (!linkedList.isEmpty()) {
                List<TreeNode> nodes = linkedList.pollFirst();
                List<TreeNode> nexts = new ArrayList<>();
                TreeNode lastOne = nodes.get(0);
                for (TreeNode node : nodes) {
                    if (null != node.left) {
                        nexts.add(node.left);
                    }
                    if (null != node.right) {
                        nexts.add(node.right);
                    }
                    lastOne = node;
                }
                if (0 < nexts.size()) {
                    linkedList.addFirst(nexts);
                }
                res.add(lastOne.val);
            }
        }
        return res;
    }
}
