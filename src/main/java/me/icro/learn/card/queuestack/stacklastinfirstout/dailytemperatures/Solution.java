package me.icro.learn.card.queuestack.stacklastinfirstout.dailytemperatures;

import java.util.Stack;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/879/
 * <p>
 * <p>
 * 思路： 逆序遍历，把每天温度保存下来，存放在一个单调递减的栈中(其实是非递增)，
 * 如果不满足这个要求，则需要将栈顶元素依次弹出，直至重新满足要求为止。
 * 不满足要求的情况即为，当前天的温度比栈顶的温度要高，重新满足要求后，
 * 栈顶元素即为后面比当前天温度高的一天，如果栈空了，然么说明后面几天没有比当前天温度还要高的。
 *
 * @author Lin
 * @since 2019-10-03 10:47 AM
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int index = T.length - 1; index >= 0; index--) {
            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
            while (!stack.isEmpty() && T[index] >= T[stack.peek()]) {
                stack.pop();
            }
            // 栈为空 即后面没有比当前天温度高的
            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
            res[index] = stack.isEmpty() ? 0 : stack.peek() - index;
            // 当前元素进栈
            stack.push(index);
        }
        return res;
    }
}
