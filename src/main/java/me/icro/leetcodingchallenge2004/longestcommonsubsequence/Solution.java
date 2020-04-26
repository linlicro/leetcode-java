package me.icro.leetcodingchallenge2004.longestcommonsubsequence;

/**
 * @author lin
 * @version v 0.1 2020/4/26
 **/
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cell = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (0 > i - 1 || 0 > j - 1) {
                        cell[i][j] = 1;
                    } else {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    }
                } else {
                    int left = 0 > i - 1 ? 0 : cell[i - 1][j];
                    int top = 0 > j - 1 ? 0 : cell[i][j - 1];
                    cell[i][j] = Math.max(left, top);
                }
            }
        }
        return cell[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new Solution().longestCommonSubsequence("abc", "abc"));
        System.out.println(new Solution().longestCommonSubsequence("abc", "def"));
    }
}
