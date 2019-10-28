package me.icro.learn.card.queuestack.stackanddfs.clonegraph;

import java.util.*;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/884/
 *
 * @author Lin
 * @since 2019-10-07 11:14 AM
 */
public class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors)
            clone.neighbors.add(dfs(n, lookup));
        return clone;
    }

}
