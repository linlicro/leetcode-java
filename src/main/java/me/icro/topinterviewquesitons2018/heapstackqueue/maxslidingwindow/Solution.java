package me.icro.topinterviewquesitons2018.heapstackqueue.maxslidingwindow;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1158/
 *
 * @author Lin
 * @since 2019-07-18 4:17 PM
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || 0 == nums.length)
            return new int[0];

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 移除 小于当前数值的; 保证对首是最大值
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            // 头部超出窗口
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            //记录
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }
}
