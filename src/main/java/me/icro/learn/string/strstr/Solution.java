package me.icro.learn.string.strstr;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/
 *
 * @author Lin
 * @since 2019-05-05 10:11 PM
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (null == haystack) return -1;
        if (null == needle) return -1;
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("", ""));
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("aaaaa", "bba"));
        System.out.println(new Solution().strStr("aaaaa", null));
    }
}
