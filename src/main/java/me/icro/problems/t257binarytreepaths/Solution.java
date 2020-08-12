package me.icro.problems.t257binarytreepaths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/8/12
 **/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        dfs(root, "", list);
        return list;
    }

    private void dfs(TreeNode cur, String path, List<String> list) {
        if (null == cur.left && null == cur.right) {
            list.add("".equals(path) ? String.valueOf(cur.val) : path + "->" + cur.val);
            return;
        }
        if (null != cur.left) {
            dfs(cur.left, "".equals(path) ? String.valueOf(cur.val) : path + "->" + cur.val, list);
        }
        if (null != cur.right) {
            dfs(cur.right, "".equals(path) ? String.valueOf(cur.val) : path + "->" + cur.val, list);
        }
    }

    public static void main(String[] args) {

    }
}
