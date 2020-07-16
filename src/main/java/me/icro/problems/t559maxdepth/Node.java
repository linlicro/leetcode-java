package me.icro.problems.t559maxdepth;

import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/7/16
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
