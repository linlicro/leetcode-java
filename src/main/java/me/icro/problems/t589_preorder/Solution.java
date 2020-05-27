package me.icro.problems.t589_preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lin
 * @version v 0.1 2020/5/27
 **/
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();

        if (null == root) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node child : root.children) {
                stack.add(child);
            }
        }
        return list;
    }

    void helper(Node root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }
}
