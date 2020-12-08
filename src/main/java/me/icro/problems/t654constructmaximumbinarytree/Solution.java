package me.icro.problems.t654constructmaximumbinarytree;

/**
 * @author lin
 * @version v 0.1 2020/12/8
 **/
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int index = getIndexMax(nums, start, end);
        TreeNode node = new TreeNode(nums[index]);
        node.left = construct(nums, start, index - 1);
        node.right = construct(nums, index + 1, end);
        return node;
    }

    private int getIndexMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = start;
        while (start <= end) {
            if (nums[start] > max) {
                index = start;
                max = nums[start];
            }
            start++;
        }
        return index;
    }

    public static void main(String[] args) {
        TreeNode root = new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(root);
    }


}
