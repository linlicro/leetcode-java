package me.icro.problems.t199rightsideview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/7
 **/
public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        addRightNode(root, res, 0);
        return res;
    }

    private void addRightNode(TreeNode node, List<Integer> res, int level) {
        if (null == node) {
            return;
        }
        if (level == res.size()) {
            res.add(node.val);
        }

        addRightNode(node.right, res, level + 1);
        addRightNode(node.left, res, level + 1);
    }

}
