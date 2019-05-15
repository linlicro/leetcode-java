package me.icro.learn.tree.sortedarraytobst;

import lombok.Data;

/**
 * 描述: Definition for a binary tree node.
 *
 * @author Lin
 * @since 2019-04-02 10:54 PM
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
