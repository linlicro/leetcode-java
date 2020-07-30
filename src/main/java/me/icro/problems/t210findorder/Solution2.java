package me.icro.problems.t210findorder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * BFS解决方案，使用 入度 概念
 *
 * @author lin
 * @version v 0.1 2020/7/30
 **/
public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] penetrations = new int[numCourses];
        int[] result = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 前置依赖的课程map
        Map<Integer, List<Integer>> map = new HashMap<>(numCourses);
        // 统计 入度
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];

            if (map.containsKey(src)) {
                map.get(src).add(dest);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(dest);
                map.put(src, list);
            }
            penetrations[dest]++;
        }
        // 入度为0的课程 放入队列
        for (int i = 0; i < numCourses; i++) {
            if (0 == penetrations[i]) {
                queue.offer(i);
            }
        }
        // 标识 - 已经选了几门课程
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            // 调整依赖课程的入度
            if (map.containsKey(course)) {
                for (Integer linked : map.get(course)) {
                    penetrations[linked]--;
                    if (0 == penetrations[linked]) {
                        queue.offer(linked);
                    }
                }
            }
        }
        // 未全部修完
        if (index != numCourses) {
            return new int[]{};
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().findOrder(3, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0}
        })));
    }
}
