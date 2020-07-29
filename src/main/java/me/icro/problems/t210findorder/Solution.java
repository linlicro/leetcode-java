package me.icro.problems.t210findorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/7/29
 **/
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] courseFlags = new int[numCourses];
        List<Integer> courseOrders = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, courseFlags, courseOrders, i)) {
                return new int[]{};
            }
        }
        return courseOrders.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] courseFlags, List<Integer> courseOrders, int i) {
        if (1 == courseFlags[i]) {
            return false;
        }
        if (2 == courseFlags[i]) {
            return true;
        }
        courseFlags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, courseFlags, courseOrders, j)) {
                return false;
            }
        }
        courseOrders.add(0, i);
        courseFlags[i] = 2;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOrder(4, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2}
        })));
    }
}
