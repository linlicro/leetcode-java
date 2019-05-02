package me.icro.problems.t344_reversestring;

/**
 * 描述:
 *  https://leetcode.com/problemset/all/
 *
 * @author Lin
 * @since 2019-05-02 2:52 PM
 */
public class Solution {
    public void reverseString(char[] s) {
        if (null == s || 1 >= s.length) return;

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
