package me.icro.problems.t98_isvalidbst;

/**
 * @author lin
 * @version v 0.1 2020/5/29
 **/
public class Solution2 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        /**
         * 中序遍历 树
         */
//        helper(root);
        if (null == root) {
            return true;
        }
        // 判断左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 判断当前节点
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

//    boolean helper(TreeNode root, int min, int max) {
//        if (null == root) {
//            return true;
//        }
//
//
//
//        helper(root.left);
//        System.out.println(root.val);
//        helper(root.right);
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(10);
        System.out.println(new Solution2().isValidBST(root));
    }
}
