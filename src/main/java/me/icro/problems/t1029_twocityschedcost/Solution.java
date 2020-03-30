package me.icro.problems.t1029_twocityschedcost;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lin
 * @version v 0.1 2020/3/30
 **/
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        class Compator1 implements Comparator<int[]> {

            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o1[0] - o2[0];
                if (0 == diff) {
                    return o1[1] - o2[1];
                }
                return diff;
            }
        }

        class Compator2 implements Comparator<int[]> {

            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        }

        int cost = 0;
        Arrays.sort(costs, new Compator1());
        for (int i = 0; i < costs.length; i++) {
            cost += costs[i][0];
        }
        Arrays.sort(costs, new Compator2());
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] - costs[i][0];
        }
        return cost;
    }

    public static void main(String[] args) {
//        int[][] costs = new int[][]{
//                new int[] {10, 20},
//                new int[] {30, 200},
//                new int[] {400, 50},
//                new int[] {30, 20}
//        };
//        System.out.println(new Solution().twoCitySchedCost(costs));

        int[][] costs = new int[][]{
                new int[] {10, 20}
        };
        System.out.println(new Solution().twoCitySchedCost(costs));
    }
}
