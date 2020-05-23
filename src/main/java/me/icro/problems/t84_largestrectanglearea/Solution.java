package me.icro.problems.t84_largestrectanglearea;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/5/23
 **/
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 解法1，暴力:
        // while 每根柱子 i
        //  while i及后面的柱子 j
        //      minHeight = min(i-height ~ j-height)
        //      maxArea = max(maxArea, (j - i) * minHeight)
        // 时间复杂: O(n^3)

        // 栈解法
        int maxArea = 0;
//        if (null == heights || 0 == heights.length) {
//            return maxArea;
//        }
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.addLast(-1);
//        // 遍历所有，当柱子遇到右边界时(上一个柱子的高度 小于 当前柱子)，可计算上一个柱子的可覆盖面积，即 确定了左边界和右边界。
//        for (int i = 0; i < heights.length; i++) {
//            int last = linkedList.peekLast();
//            if (-1 == last) {
//                linkedList.addLast(i);
//                continue;
//            }
//            while (-1 != last && heights[i] < heights[last]) {
//                linkedList.pollLast();
//                maxArea = Math.max(maxArea, heights[last] * (i - linkedList.peekLast() - 1));
//                last = linkedList.peekLast();
//            }
//            linkedList.addLast(i);
//        }
//        // 若 栈非空，计算剩余柱子的覆盖面积，右边界为 最右边，左边界为 上一个柱子的位置
//        while (!linkedList.isEmpty() && -1 != linkedList.peekLast()) {
//            int cur = linkedList.pollLast();
//            maxArea = Math.max(maxArea, heights[cur] * (heights.length - linkedList.peekLast() - 1));
//        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(-1);
        for (int i = 0; i < heights.length; i++) {
            while (-1 !=linkedList.peekLast() && heights[i] <= heights[linkedList.peekLast()]) {
                maxArea = Math.max(maxArea, heights[linkedList.pollLast()] * (i - linkedList.peekLast() - 1));
            }
            linkedList.addLast(i);
        }
        while (-1 != linkedList.peekLast()) {
            maxArea = Math.max(maxArea, heights[linkedList.pollLast()] * (heights.length - linkedList.peekLast() - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{1}));
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 2}));
    }
}
