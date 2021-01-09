package me.icro.problems.t120minimumtotal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2021/1/9
 **/
public class Solution2 {

    int sum = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0, 0);
        return sum;
    }

    private void dfs(List<List<Integer>> triangle, int x, int y, int temp) {
        if (triangle.size() == x) {
             sum = Math.min(temp, sum);
            return;
        }
        dfs(triangle, x + 1, y, temp + triangle.get(x).get(y));
        dfs(triangle, x + 1, y + 1, temp + triangle.get(x).get(y));
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(new Solution2().minimumTotal(triangle));
    }
}
