package me.icro.learn.tree.sortedarraytobst;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/51/
 *
 * @author Lin
 * @since 2019-05-15 1:16 PM
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || 0 == nums.length) return null;

        int middle_index = nums.length / 2;
        TreeNode root = new TreeNode(nums[middle_index]);
        root.left = 0 == middle_index ? null
                : sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle_index));
        root.right = (middle_index + 1) == nums.length ? null
                : sortedArrayToBST(Arrays.copyOfRange(nums, middle_index + 1, nums.length));

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new Solution().sortedArrayToBST(new int[] {-10,-3,0,5,9});
        TreeNode treeNode2 = new Solution().sortedArrayToBST(new int[] {-10});
        TreeNode treeNode3 = new Solution().sortedArrayToBST(new int[] {-10,-3,0,5,9, 11, 100, 200});
        System.out.println("done");
    }
}
