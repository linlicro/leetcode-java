package me.icro.learn.card.queuestack.stackanddfs.clonegraph;

import lombok.Data;

import java.util.List;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-10-07 11:14 AM
 */
@Data
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
