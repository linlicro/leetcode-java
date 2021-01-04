package me.icro.lcof.o55imaxdepth;

/**
 * @author lin
 * @version v 0.1 2021/1/5
 **/
public class Solutionn {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
