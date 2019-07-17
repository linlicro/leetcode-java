package me.icro.topinterviewquesitons2018.heapstackqueue.kthsmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1156/
 *
 * 思路:
 *  * 使用一个优先级队列保存数据，队列大小为k，然后遍历矩阵，遍历完之后，直接取出top，即为kth_smallest_value
 * @author Lin
 * @since 2019-07-17 2:07 PM
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                priorityQueue.offer(matrix[i][j]);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                new int[] {1,2,3},
                new int[] {4,5,6},
                new int[] {7,8,9},
        };
        System.out.println(new Solution().kthSmallest(matrix, 6));
    }
}
