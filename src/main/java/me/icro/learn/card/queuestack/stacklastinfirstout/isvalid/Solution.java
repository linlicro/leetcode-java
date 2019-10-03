package me.icro.learn.card.queuestack.stacklastinfirstout.isvalid;

import java.util.Stack;

/**
 * 描述:
 * https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/878/
 *
 * @author Lin
 * @since 2019-10-03 10:30 AM
 */
public class Solution {
    public boolean isValid(String s) {
        if (null == s)
            return false;
        if (0 == s.length())
            return true;
        if (1 == s.length() % 2)
            return false;

        Stack<String> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            String pre = stack.isEmpty() ? "" : stack.pop();
            String cur = s.substring(index, index + 1);
            if ("".equals(pre)) {
                stack.push(cur);
                continue;
            }
            if ("{".equals(cur)
                    || "(".equals(cur)
                    || "[".equals(cur)) {
                stack.push(pre);
                stack.push(cur);
                continue;
            }
            if ("}".equals(cur) && !"{".equals(pre)) {
                return false;
            }
            if (")".equals(cur) && !"(".equals(pre)) {
                return false;
            }
            if ("]".equals(cur) && !"[".equals(pre)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().isValid("()"));
        //System.out.println(new Solution().isValid("()[]{}"));
        //System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("{[]}"));
    }
}
