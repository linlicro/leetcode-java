package me.icro.problems.t72mindistance;

/**
 * @author lin
 * @version v 0.1 2020/8/25
 **/
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (0 == len1 || 0 == len2) {
            return Math.max(len1, len2);
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("", "abc"));
        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("intention", "execution"));
    }
}
