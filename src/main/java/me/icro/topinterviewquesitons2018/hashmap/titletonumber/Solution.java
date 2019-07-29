package me.icro.topinterviewquesitons2018.hashmap.titletonumber;

import java.util.HashMap;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/268/hash-map/1162/
 *
 * @author Lin
 * @since 2019-07-29 11:51 AM
 */
public class Solution {
    public int titleToNumber(String s) {
        if (null == s || 0 == s.length()) return 0;

        if (1 == s.length()) return (s.charAt(0) - 'A') + 1;
        return 26 * titleToNumber(s.substring(0, s.length() - 1)) + titleToNumber(s.substring(s.length() - 1));

    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("B"));
        System.out.println(new Solution().titleToNumber("AB"));
        System.out.println(new Solution().titleToNumber("ZY"));
        System.out.println(new Solution().titleToNumber("AAA"));
    }
}
