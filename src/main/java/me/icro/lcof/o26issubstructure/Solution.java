package me.icro.lcof.o26issubstructure;

/**
 * @author lin
 * @version v 0.1 2020/12/22
 **/
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode a, TreeNode b) {
        if (null == b) {
            return true;
        }
        if (null == a || a.val != b.val) {
            return false;
        }
        return helper(a.left, b.left) && helper(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(0);
        t1.right = new TreeNode(1);
        t1.left.left = new TreeNode(-4);
        t1.left.right = new TreeNode(-3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(-4);

        System.out.println(new Solution().isSubStructure(t1, t2));

        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);

        t2 = new TreeNode(3);
        System.out.println(new Solution().isSubStructure(t1, t2));
    }
}
