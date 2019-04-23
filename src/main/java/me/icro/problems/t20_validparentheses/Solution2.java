package me.icro.problems.t20_validparentheses;

import java.util.LinkedList;

/**
 * 描述:
 * 20. Valid Parentheses
 *
 * @author Lin
 * @since 2019-04-01 10:57 PM
 */
public class Solution2 {
    public boolean isValid(String s) {
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
        System.out.println(new Solution2().isValid(""));
        System.out.println(new Solution2().isValid("{}"));
        System.out.println(new Solution2().isValid("{[]}"));
        System.out.println(new Solution2().isValid("{[()]}"));
        System.out.println(new Solution2().isValid("{}[]()"));
        System.out.println(new Solution2().isValid("{([])}()[{}]"));
        System.out.println(new Solution2().isValid("["));
        System.out.println(new Solution2().isValid("[["));
        System.out.println(new Solution2().isValid("[(])"));
    }
}
