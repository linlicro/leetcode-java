package me.icro.topinterviewquesitons2018.linkedlist.copyrandomlist;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-07-23 11:21 AM
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
