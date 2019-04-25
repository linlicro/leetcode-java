package me.icro.learn.array.rotate;

/**
 * 描述:
 *  Using Cyclic Replacements
 *  
 * @author Lin
 * @since 2019-04-24 7:20 AM
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
