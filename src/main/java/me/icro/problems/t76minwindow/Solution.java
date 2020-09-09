package me.icro.problems.t76minwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/9/8
 **/
public class Solution {
    public String minWindow(String s, String t) {
        if (null == s || null == t) {
            return "";
        }
        if (0 == t.length() || 0 == s.length() || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> tCharCount = new HashMap<>(8);
        Map<Character, Integer> sCharCount = new HashMap<>(8);
        for (int i = 0; i < t.length(); i++) {
            tCharCount.put(t.charAt(i), tCharCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        int start = 0, len = Integer.MAX_VALUE;
        int left = 0, right = 0, distance = t.length();
        while (right < s.length()) {
            char cur = s.charAt(right);
            // 没有这个字符的时候
            if (!tCharCount.containsKey(cur)) {
                right++;
                continue;
            }
            // 只有当该字符的个数 小于 目标字符串里的相应字符个数，才缩小差距/距离
            if (sCharCount.getOrDefault(cur, 0) < tCharCount.get(cur)) {
                distance--;
            }
            sCharCount.put(cur, sCharCount.getOrDefault(cur, 0) + 1);
            right++;
            // 窗口内已含有子串，下一步 移动左指针 直到 不再满足条件
            while (0 == distance) {
                // 更新结果
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (!sCharCount.containsKey(leftChar)) {
                    left++;
                    continue;
                }
                if (tCharCount.get(leftChar).equals(sCharCount.get(leftChar))) {
                    distance++;
                }
                sCharCount.put(leftChar, sCharCount.get(leftChar) - 1);
                left++;
            }
        }
        return Integer.MAX_VALUE == len ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ZDFGHJ", ""));
        System.out.println(new Solution().minWindow("ZDFGHJ", "ABC"));
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("ABC", "ABC"));
    }
}
