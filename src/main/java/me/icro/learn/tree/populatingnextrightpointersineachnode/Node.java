package me.icro.learn.tree.populatingnextrightpointersineachnode;

import lombok.Data;

/**
 * 描述: Definition for a binary tree node.
 *
 * @author Lin
 * @since 2019-04-02 10:54 PM
 */
@Data
public class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node() {
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
