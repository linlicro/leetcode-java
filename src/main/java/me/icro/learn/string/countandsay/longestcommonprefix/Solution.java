package me.icro.learn.string.countandsay.longestcommonprefix;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/40/
 *
 * @author Lin
 * @since 2019-05-06 7:33 AM
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) return "";

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char cur_char = '*';
        boolean end = false;
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (index == strs[i].length() || null == strs[i]) {
                    end = true;
                    break;
                }

                if (0 == i) {
                    cur_char = strs[i].charAt(index);
                    continue;
                }

                if (cur_char != strs[i].charAt(index)) {
                    end = true;
                    break;
                }
            }

            if (end) break;

            stringBuilder.append(cur_char);
            index++;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[] {}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
