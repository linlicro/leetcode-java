package me.icro.problems.t590_postorder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/5/27
 **/
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    void helper(Node root, List<Integer> res) {
        if (null == root) {
            return;
        }
        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }

    public static void main(String[] args) {

    }
}
