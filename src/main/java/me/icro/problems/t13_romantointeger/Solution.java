package me.icro.problems.t13_romantointeger;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 *
 * @author Lin
 * @since 2019-03-26 9:47 PM
 */
public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<String, Integer>() {
            private static final long serialVersionUID = 4496753399902425495L;

            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
                put("II", 2);
                put("III", 3);
                put("IV", 4);
                put("IX", 9);
                put("XX", 20);
                put("XXX", 30);
                put("XL", 40);
                put("XC", 90);
                put("CC", 200);
                put("CCC", 300);
                put("CD", 400);
                put("CM", 900);
                put("MM", 2000);
                put("MMM", 3000);
            }
        };

        int index = 0;
        int result = 0;
        while (index < s.length()) {
            String tmp = s.substring(index, index + 1);
            int index2 = index + 1;
            while (index2 < s.length() && romanMap.get(tmp) <= romanMap.get(s.substring(index2, index2 + 1))) {
                tmp += s.substring(index2, index2 + 1);
                index2++;
            }
            result += romanMap.get(tmp);
            index += (index2 - index);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("I"));
        System.out.println(new Solution().romanToInt("II"));
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("XXX"));
        System.out.println(new Solution().romanToInt("XL"));
        System.out.println(new Solution().romanToInt("LVIII"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
        System.out.println(new Solution().romanToInt("MMMCMXCIX"));
    }
}
