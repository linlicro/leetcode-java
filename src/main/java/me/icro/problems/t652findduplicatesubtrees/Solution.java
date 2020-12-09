package me.icro.problems.t652findduplicatesubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/8
 **/
public class Solution {

    List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> subTreeCountMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode node) {
        if (null == node) {
            return "#";
        }

        String left = traverse(node.left);
        String right = traverse(node.right);

        String nodeStr = left + "," + right + "," + node.val;
        int count = subTreeCountMap.getOrDefault(nodeStr, 0);
        if (count == 1) {
            res.add(node);
        }

        subTreeCountMap.put(nodeStr, count + 1);
        return nodeStr;
    }


}
