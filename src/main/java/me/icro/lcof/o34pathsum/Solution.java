package me.icro.lcof.o34pathsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/12/24
 **/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        find(root, sum, new ArrayList<>());
        return res;
    }

    private void find(TreeNode cur, int sum, List<Integer> list) {
        if (null == cur) {
            return;
        }

        list.add(cur.val);
        if (cur.val == sum && null == cur.left && null == cur.right) {
            res.add(new ArrayList<>(list));
        } else {
            find(cur.left, sum - cur.val, list);
            find(cur.right, sum - cur.val, list);
        }

        list.remove(list.size() - 1);
    }
}
