package me.icro.lcof.o36treetodoublylist;

/**
 * @author lin
 * @version v 0.1 2020/12/28
 **/
public class Solution {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void inorder(Node node) {
        if (null == node) {
            return;
        }
        inorder(node.left);
        if (null == pre) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        inorder(node.right);
    }
}
