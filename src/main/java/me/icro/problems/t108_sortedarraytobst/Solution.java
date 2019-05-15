package me.icro.problems.t108_sortedarraytobst;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-15 1:43 PM
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
}
