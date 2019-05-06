package me.icro.problems.t28_strStr;

/**
 * 描述:
 *  https://leetcode.com/problems/implement-strstr/
 *
 * @author Lin
 * @since 2019-05-05 10:16 PM
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (null == haystack) return -1;
        if (null == needle) return -1;
        return haystack.indexOf(needle);
    }
}
