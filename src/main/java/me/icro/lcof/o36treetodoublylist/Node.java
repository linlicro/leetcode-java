package me.icro.lcof.o36treetodoublylist;

import lombok.Data;

/**
 * @author lin
 * @version v 0.1 2020/12/24
 **/
@Data
public class Node {
    int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
