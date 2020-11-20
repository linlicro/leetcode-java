package me.icro.problems.t80removeduplicates;

/**
 * @author lin
 * @version v 0.1 2020/11/20
 **/
public class Solution {
    int k = 2;

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < k) {
            return len;
        }
        int left = 1, right = 1;
        int count = 1;
        while (right < len) {
            if (nums[right] == nums[right - 1]) {
                count++;
                if (count > k) {
                    right++;
                    continue;
                }
            } else {
                count = 1;
            }
            nums[left++] = nums[right];
            right++;
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
