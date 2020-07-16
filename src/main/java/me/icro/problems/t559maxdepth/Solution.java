package me.icro.problems.t559maxdepth;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/7/16
 **/
public class Solution {
    public int maxDepth(Node root) {
        int count = 0;
        if (null == root) {
            return count;
        }
        LinkedList<List<Node>> linkedList = new LinkedList<>();
        linkedList.add(Collections.singletonList(root));
        while (!linkedList.isEmpty()) {
            count++;
            List<Node> nodes = linkedList.pollFirst();
            List<Node> nodesNext = new ArrayList<>();
            for (Node node : nodes) {
                if (Objects.isNull(node.children)) {
                    continue;
                }
                nodesNext.addAll(node.children);
            }
            if (0 != nodesNext.size()) {
                linkedList.addLast(nodesNext);
            }
        }
        return count;
    }
}
