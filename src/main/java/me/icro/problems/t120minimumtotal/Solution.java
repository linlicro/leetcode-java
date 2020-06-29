package me.icro.problems.t120minimumtotal;

import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/6/29
 **/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || 0 == triangle.size()) {
            return 0;
        }

        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            // 左侧端
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            // 右侧端
            dp[i][triangle.get(i).size() - 1] = dp[i - 1][triangle.get(i).size() - 1 - 1] + triangle.get(i).get(triangle.get(i).size() - 1);
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int each : dp[m - 1]) {
            res = Math.min(res, each);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
