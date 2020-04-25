package me.icro.leetcodingchallenge2004.canjump;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author lin
 * @version v 0.1 2020/4/25
 **/
public class Solution {
    public boolean canJump(int[] nums) {
        int index = 0;
        int maxJump = 0;
        for (int i = 0; i < nums.length - 1 && index <= maxJump; i++) {
            maxJump = Math.max(maxJump, index + nums[i]);
            index++;
        }
        return maxJump >= nums.length - 1;
    }

    public static void main(String[] args) {
        // [8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5]

        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Solution().canJump(new int[]{1, 1, 1, 0}));
    }
}
