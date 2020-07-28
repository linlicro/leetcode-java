package me.icro.problems.t207canfinish;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 超时，因为需要枚举出 符合条件的选课结果，时间复杂度为 O(n!)
 *
 * @author lin
 * @version v 0.1 2020/7/28
 **/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int count = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>(numCourses);
        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[0])) {
                map.put(prerequisite[0], new HashSet<>());
            }
            map.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(numCourses, map, visited, count)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int numCourses, Map<Integer, Set<Integer>> map, int[] visited, int count) {
        if (numCourses == count) {
            return true;
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                // 是否有前置依赖 且前置还未选择
                boolean pre = false;
                if (map.containsKey(i)) {
                    for (Integer preCourse : map.get(i)) {
                        if (visited[preCourse] == 0) {
                            pre = true;
                            break;
                        }
                    }
                }

                if (pre) {
                    continue;
                }
                visited[i] = 1;
                if (dfs(numCourses, map, visited, ++count)) {
                    return true;
                }
                visited[i] = 0;
                count--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().canFinish(2,
//                new int[][]{
//                        new int[]{1, 0}
//                }));
//
//        System.out.println(new Solution().canFinish(2,
//                new int[][]{
//                        new int[]{1, 0},
//                        new int[]{0, 1}
//                }));

        System.out.println(new Solution().canFinish(10,
                new int[][]{
                        new int[]{0, 8},
                        new int[]{0, 1},
                        new int[]{8, 1},
                        new int[]{1, 0}
                }));
    }
}
