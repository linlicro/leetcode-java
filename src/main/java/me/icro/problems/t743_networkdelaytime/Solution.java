package me.icro.problems.t743_networkdelaytime;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/3/23
 **/
public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {

        if (1 == N) {
            return 0;
        }

        Map<Integer, Integer> costs = new HashMap<>(N);
        costs.put(K, 0);
        int[] parents = new int[N + 1];
        int[] processed = new int[N + 1];
        parents[K] = -1;
        int cur = findLowestCostNode(costs, processed);
        while (-1 != cur) {
            int cost = costs.get(cur);
            for (int[] time : times) {
                if (cur != time[0]) {
                    continue;
                }
                int neighbor = time[1];
                int neighborCost = cost + time[2];
                if (costs.getOrDefault(neighbor, Integer.MAX_VALUE) > neighborCost) {
                    costs.put(neighbor, neighborCost);
                    parents[neighbor] = cur;
                }
            }
            processed[cur] = 1;
            cur = findLowestCostNode(costs, processed);
        }

        int delayTime = -1;
        for (int i = 1; i <=N; i++) {
            if (!costs.containsKey(i)) {
                return -1;
            }
            delayTime = Integer.max(delayTime, costs.get(i));
        }

        return delayTime;
    }

    int findLowestCostNode(Map<Integer, Integer> costs, int[] processed) {
        final int[] node = {-1};
        final int[] lowestCost = {Integer.MAX_VALUE};
        costs.forEach( (k, v) -> {
            if (v < lowestCost[0] && 0 == processed[k]) {
                node[0] = k;
                lowestCost[0] = v;
            }
        });

        return node[0];
    }

    public static void main(String[] args) {

//        [[3,5,78],[2,1,1],[1,3,0],[4,3,59],[5,3,85],[5,2,22],[2,4,23],[1,4,43],[4,5,75],[5,1,15],[1,5,91],[4,1,16],[3,2,98],[3,4,22],[5,4,31],[1,2,0],[2,5,4],[4,2,51],[3,1,36],[2,3,59]]
//          5
//          5
        int[][] times = new int[][]{
                new int[]{3,5,78},
                new int[]{2,1,1},
                new int[]{1,3,0},
                new int[]{4,3,59},
                new int[]{5,3,85},
                new int[]{5,2,22},
                new int[]{2,4,23},
                new int[]{1,4,43},
                new int[]{4,5,75},
                new int[]{5,1,15},
                new int[]{1,5,91},
                new int[]{4,1,16},
                new int[]{3,2,98},
                new int[]{3,4,22},
                new int[]{5,4,31},
                new int[]{1,2,0},
                new int[]{2,5,4},
                new int[]{4,2,51},
                new int[]{3,1,36},
                new int[]{2,3,59},
        };
        System.out.println(new Solution().networkDelayTime(times, 5, 5));

//        int[][] times = new int[][]{
//                new int[]{2, 1, 1},
//                new int[]{2, 3, 1},
//                new int[]{3, 4, 2}
//        };
//        System.out.println(new Solution().networkDelayTime(times, 4, 2));
    }

}
