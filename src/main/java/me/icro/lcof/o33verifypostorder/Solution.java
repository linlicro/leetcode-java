package me.icro.lcof.o33verifypostorder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/12/24
 **/
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) {
            return true;
        }
        int[] inorder = new int[postorder.length];
        System.arraycopy(postorder, 0, inorder, 0, postorder.length);
        Arrays.sort(inorder);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] inorder, int inS, int inE, int[] postorder, int postS, int postE) {
        if (inS == inE && inorder[inS] == postorder[postS]) {
            return true;
        }
        int root = postorder[postE];
        int index = map.getOrDefault(root, -1);
        if (index < inS || index > inE) {
            return false;
        }
        int lenLeft = index - inS;
        int lenRight = inE - index;
        boolean leftVerify = lenLeft == 0 || helper(inorder, inS, index - 1, postorder, postS, postS + lenLeft - 1);
        boolean rightVerify = lenRight == 0 || helper(inorder, index + 1, inE, postorder, postS + lenLeft, postE - 1);
        return leftVerify && rightVerify;
    }

    private int findIndex(int[] inorder, int root, int start, int end) {
        for (int i = end; i >= start; i--) {
            if (root == inorder[i]) {
                return start + i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().verifyPostorder(new int[]{1, 3, 2, 6, 5}));
//        System.out.println(new Solution().verifyPostorder(new int[]{1, 6, 3, 2, 5}));
//        System.out.println(new Solution().verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 1}));
        System.out.println(new Solution().verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }
}
