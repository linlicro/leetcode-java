package me.icro.leetcodingchallenge2004.minpathsum;

/**
 * @author lin
 * @version v 0.1 2020/4/18
 **/
public class Solution {
    public int minPathSum(int[][] grid) {
        if (null == grid || 0 == grid.length) {
            return 0;
        }
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (0 == m && 0 == n) {
                    continue;
                }
                int left = 0 == n ? Integer.MAX_VALUE : grid[m][n - 1];
                int top = 0 == m ? Integer.MAX_VALUE : grid[m - 1][n];
                grid[m][n] += Integer.min(left, top);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][] {
                new int[] {1,3,1},
                new int[] {1,5,1},
                new int[] {4,2,1}
        }));
    }
}
