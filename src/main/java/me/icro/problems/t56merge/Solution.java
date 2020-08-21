package me.icro.problems.t56merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/8/21
 **/
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = new int[2];
            cur[0] = intervals[i][0];
            cur[1] = intervals[i][1];
            while (i + 1 < intervals.length && (intervals[i + 1][0] <= cur[1] || intervals[i + 1][1] <= cur[1])) {
                cur[1] = Math.max(intervals[i + 1][1], cur[1]);
                i++;
            }
            list.add(cur);
        }

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{
                new int[]{1, 3},
                new int[]{8, 10},
                new int[]{2, 6},
                new int[]{15, 18}
        })));

        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{
                new int[]{1, 3},
                new int[]{3, 10}
        })));

        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{
                new int[]{1, 4},
                new int[]{2, 3}
        })));

        System.out.println(Arrays.deepToString(new Solution().merge(new int[][]{
                new int[]{2, 3},
                new int[]{4, 5},
                new int[]{6, 7},
                new int[]{8, 9},
                new int[]{1, 10}
        })));
    }
}
