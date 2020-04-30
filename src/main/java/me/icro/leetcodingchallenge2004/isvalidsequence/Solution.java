package me.icro.leetcodingchallenge2004.isvalidsequence;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/4/30
 **/
public class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return existPath(root, arr, 0);
    }

    public static boolean existPath(TreeNode root, int[] arr, int index) {
        // If root is NULL, then there must not be any element
        // in array.
        if (root == null) {
            return arr.length == 0;
        }

        // If this node is a leaf and matches with last entry
        // of array.
        if ((root.left == null && root.right == null) && (index == arr.length - 1 && root.val == arr[index])) {
            return true;
        }

        // If current node is equal to arr[index] this means
        // that till this level path has been matched and
        // remaining path can be either in left subtree or
        // right subtree.
        return (index < arr.length && (root.val == arr[index] && (existPath(root.left, arr, index + 1) || existPath(root.right, arr, index + 1))));
    }


}
