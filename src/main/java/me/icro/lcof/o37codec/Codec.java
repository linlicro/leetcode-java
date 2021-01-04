package me.icro.lcof.o37codec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author lin
 * @version v 0.1 2021/1/5
 **/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(null == cur ? null : cur.val);
            if (null == cur) {
                continue;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return list.stream().map(each -> null == each ? "null" : each.toString()).collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        TreeNode root = "null".equals(list[0]) ? null : new TreeNode(Integer.parseInt(list[0]));
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = "null".equals(list[index]) ? null : new TreeNode(Integer.parseInt(list[index]));
            index++;
            TreeNode right = "null".equals(list[index]) ? null : new TreeNode(Integer.parseInt(list[index]));
            index++;
            if (null != left) {
                cur.left = left;
                queue.add(left);
            }
            if (null != right) {
                cur.right = right;
                queue.add(right);
            }

        }
        return root;
    }
}
