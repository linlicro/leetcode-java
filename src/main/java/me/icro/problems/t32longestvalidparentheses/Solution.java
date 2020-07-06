package me.icro.problems.t32longestvalidparentheses;

import java.util.LinkedList;

/**
 * @author lin
 * @version v 0.1 2020/7/6
 **/
public class Solution {
    /**
     * 栈 解法
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        // -1 为参照物
        linkedList.addLast(-1);
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                // 左括号 入栈
                linkedList.addLast(i);
                continue;
            }
            // 右括号 出栈
            linkedList.pollLast();
            if (0 == linkedList.size()) {
                // 当栈空了 填入'参照物'
                linkedList.addLast(i);
            } else {
                max = Math.max(max, i - linkedList.peekLast());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses("()(()))())()"));
    }
}
