package me.icro.learn.string.reversestring;

import java.util.Arrays;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/
 *
 * @author Lin
 * @since 2019-05-02 2:47 PM
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

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
