package me.icro.problems.t1143longestcommonsubsequence;

/**
 * @author lin
 * @version v 0.1 2020/6/22
 **/
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (null == text1 || 0 == text1.length()) {
            return 0;
        }
        if (null == text2 || 0 == text2.length()) {
            return 0;
        }
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[ch1.length + 1][ch2.length + 1];
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
    }
}
