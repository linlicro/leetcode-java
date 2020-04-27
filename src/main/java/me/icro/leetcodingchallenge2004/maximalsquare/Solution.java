package me.icro.leetcodingchallenge2004.maximalsquare;

/**
 * @author lin
 * @version v 0.1 2020/4/27
 **/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (null == matrix || 0 == matrix.length) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int result = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if ('1' == matrix[i - 1][j - 1]) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][] {
                new char[] {'1', '0', '1', '0', '0'},
                new char[] {'1', '0', '1', '1', '1'},
                new char[] {'1', '1', '1', '1', '1'},
                new char[] {'1', '0', '0', '1', '0'},
        }));
        System.out.println(new Solution().maximalSquare(new char[][] {
                new char[] {'1', '0', '1', '0', '0'},
                new char[] {'1', '0', '1', '1', '1'},
                new char[] {'1', '1', '1', '0', '1'},
                new char[] {'1', '0', '0', '1', '0'},
        }));
        System.out.println(new Solution().maximalSquare(new char[][] {
                new char[] {'1', '0', '1', '0', '0'},
                new char[] {'1', '0', '1', '1', '1'},
                new char[] {'1', '1', '1', '1', '1'},
                new char[] {'1', '0', '1', '1', '1'},
        }));
        System.out.println(new Solution().maximalSquare(new char[][] {
                new char[] {'1'}
        }));
        System.out.println(new Solution().maximalSquare(new char[][] {
                new char[] {}
        }));
    }
}
