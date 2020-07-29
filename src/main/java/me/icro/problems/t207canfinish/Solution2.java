package me.icro.problems.t207canfinish;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS 判断是否存在'环'
 * @author lin
 * @version v 0.1 2020/7/28
 **/
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 课程的状态标识
        // 0 - 未选择 (初始状态)
        // 1 - 已选且在判断中`是否存在环`
        // 2 - 该课程不存在环，可选
        int[] courseFlags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, courseFlags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] courseFlags, int i) {
        if (1 == courseFlags[i]) {
            // 存在 环
            return false;
        }
        if (2 == courseFlags[i]) {
            // 已经选择
            return true;
        }
        courseFlags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            // 判断 先修课程 是否存在'环'
            if (!dfs(adjacency, courseFlags, j)) {
                return false;
            }
        }
        //
        courseFlags[i] = 2;
        return true;
    }
}
