package me.icro.problems.t450deletenode;

/**
 * @author lin
 * @version v 0.1 2020/12/10
 **/
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (key == root.val) {
            if (null == root.left) {
                return root.right;
            }
            if (null == root.right) {
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(7);
//        root = new Solution().deleteNode(root, 0);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root = new Solution().deleteNode(root, 7);
        System.out.println(root);
    }
}
