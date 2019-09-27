package me.icro.learn.card.datastructure.binarytree.conclusion.connect;

import lombok.Data;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-09-27 4:31 PM
 */
@Data
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
