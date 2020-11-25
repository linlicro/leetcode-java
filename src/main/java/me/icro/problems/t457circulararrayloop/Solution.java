package me.icro.problems.t457circulararrayloop;

/**
 * @author lin
 * @version v 0.1 2020/11/25
 **/
public class Solution {
    int len;

    public boolean circularArrayLoop(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }
        len = nums.length;

        for (int i = 0; i < len; i++) {
            if (0 == nums[i]) {
                continue;
            }

            int slow = i, fast = advance(nums, slow);
            // 保持一个方向前进
            while (nums[i] * nums[fast] > 0 && nums[i] * nums[advance(nums, fast)] > 0) {
                // 快慢指针相遇时
                if (slow == fast) {
                    if (slow == advance(nums, slow)) {
                        break;
                    }
                    return true;
                }
                slow = advance(nums, slow);
                fast = advance(nums, advance(nums, fast));
            }

            slow = i;
            while (nums[i] * nums[slow] > 0) {
                int tmp = advance(nums, slow);
                nums[slow] = 0;
                slow = tmp;
            }
        }
        return false;
    }

    private int advance(int[] nums, int i) {
        if (nums[i] < 0) {
            int next = i + nums[i];
            while (next < 0) {
                next += nums.length;
            }
            return next;
        } else {
            int next = (nums[i] + i) % nums.length;
            return next;
        }
    }
}
