package me.icro.t20_validparentheses;

import java.util.LinkedList;

/**
 * 描述:
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author Lin
 * @since 2019-04-01 4:45 PM
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) tmp += ")";
            else if ('{' == c) tmp += "}";
            else if ('[' == c) tmp += "]";
            else {
                if (tmp.length() == 0) return false;
                if (tmp.charAt(tmp.length() - 1) != c) return false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
        if (tmp.length() > 0) return false;
        return true;
    }

    public boolean isValid2(String s) {
        LinkedList stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.addFirst(s.charAt(i));
            else {

                if (stack.size() == 0)
                    return false;

                Character c = (Character) stack.removeFirst();

                Character match;
                if (s.charAt(i) == ')')
                    match = '(';
                else if (s.charAt(i) == ']')
                    match = '[';
                else {
                    assert s.charAt(i) == '}';
                    match = '{';
                }

                if (c != match)
                    return false;
            }

        if (stack.size() != 0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid(""));
        System.out.println(new Solution().isValid("{}"));
        System.out.println(new Solution().isValid("{[]}"));
        System.out.println(new Solution().isValid("{[()]}"));
        System.out.println(new Solution().isValid("{}[]()"));
        System.out.println(new Solution().isValid("{([])}()[{}]"));
        System.out.println(new Solution().isValid("["));
        System.out.println(new Solution().isValid("[["));
        System.out.println(new Solution().isValid("[(])"));
    }

}
