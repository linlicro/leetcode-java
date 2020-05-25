package me.icro.problems.t239_maxslidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/5/23
 **/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 双向队列解法
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 保证队首为最大值
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            // 当前值 加入
            deque.addLast(i);
            // 移除 超出窗口的队首
            if (i - deque.getFirst() > k) {
                deque.removeFirst();
            }
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
