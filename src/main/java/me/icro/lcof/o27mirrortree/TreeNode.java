package me.icro.lcof.o27mirrortree;

import lombok.Data;

/**
 * 描述: Definition for a binary tree node.
 *
 * @author Lin
 * @since 2019-09-10 3:38 PM
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
