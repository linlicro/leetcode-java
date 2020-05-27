package me.icro.problems.t429_levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lin
 * @version v 0.1 2020/5/27
 **/
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == root) {
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

//        queue.add(null);
//        List<Integer> innerList = new ArrayList<>();
//        lists.add(innerList);
//        while (!queue.isEmpty()) {
//            Node cur = queue.poll();
//            if (null == cur) {
//                if (queue.isEmpty()) {
//                    break;
//                }
//                innerList = new ArrayList<>();
//                lists.add(innerList);
//                queue.add(null);
//                continue;
//            }
//            innerList.add(cur.val);
//            queue.addAll(cur.children);
//        }

        // 简化
        while (!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                Node cur = queue.poll();
                innerList.add(cur.val);
                queue.addAll(cur.children);
            }
            lists.add(innerList);
        }

        return lists;
    }
}
