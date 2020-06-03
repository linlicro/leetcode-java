package me.icro.problems.t105_buildtree;


import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/6/3
 **/
public class Solution {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || 0 == preorder.length) {
            return null;
        }
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndexInOrder = indexMap.get(preorder[preLeft]);
        int leftPreNextLeft = preLeft + 1;
        int leftPreNextRight = preLeft + (rootIndexInOrder - inLeft);
        int leftInNextLeft = inLeft;
        int leftInNextRight = inLeft + (rootIndexInOrder - inLeft - 1);
        root.left = buildTree(preorder, leftPreNextLeft, leftPreNextRight, inorder, leftInNextLeft, leftInNextRight);

        int rightPreNextLeft = leftPreNextRight + 1;
        int rightPreNextRight = preRight;
        int rightInNextLeft = rootIndexInOrder + 1;
        int rightInNextRight = inRight;
        root.right = buildTree(preorder, rightPreNextLeft, rightPreNextRight, inorder, rightInNextLeft, rightInNextRight);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        System.out.println(root);
//        TreeNode root1 = new Solution().buildTree(new int[]{3}, new int[]{3});
//        System.out.println(root1);
//        TreeNode root2 = new Solution().buildTree(new int[]{3, 1}, new int[]{1, 3});
//        System.out.println(root2);
        TreeNode root2 = new Solution().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(root2);
    }
}
