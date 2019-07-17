package me.icro.topinterviewquesitons2018.heapstackqueue.topkfrequent;

import java.util.*;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1157/
 *
 * 思路: Map计数，优先队列记录前k高频的数据。
 * @author Lin
 * @since 2019-07-17 2:38 PM
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k,
                Comparator.comparing(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<Integer> list = new ArrayList<>(k);
        while (priorityQueue.size() > 0) {
            list.add(0, priorityQueue.poll().getKey());
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
