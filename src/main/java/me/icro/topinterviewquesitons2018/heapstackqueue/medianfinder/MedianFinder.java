package me.icro.topinterviewquesitons2018.heapstackqueue.medianfinder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1155/
 * <p>
 * 分析:
 * 首先，使用两个PriorityQueue来实现。将(有序的)数组按中间值划分为两部分，
 * 前一部分(小的数值)保存在left_heap，后一部分(大的数值)保存在right_heap。
 * left_heap倒序排序；right_heap顺序排序。
 * <p>
 * 添加数值时：
 * step1. 往right_heap添加，
 * step2. right_head poll最小值 ==> left_heap, 去排序下
 * step3. 若left_heap.size > right_heap.size，left_size的最大值poll回right_heap
 * <p>
 * 取中间值时:
 * 当 right_heap.size == left_heap 时候，返回 (right_heap.peek() + left_heap.peek())/2;
 * 否则，返回 right_heap.peek()
 *
 * @author Lin
 * @since 2019-07-16 4:36 PM
 */
class MedianFinder {

    PriorityQueue<Integer> left_heap;
    PriorityQueue<Integer> right_heap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        left_heap = new PriorityQueue<>(Comparator.reverseOrder());
        right_heap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        right_heap.offer(num);
        left_heap.offer(right_heap.poll());
        if (right_heap.size() < left_heap.size()) {
            right_heap.offer(left_heap.poll());
        }
    }

    public double findMedian() {
        if (right_heap.size() == left_heap.size()) {
            return (right_heap.peek() + left_heap.peek()) / 2.0;
        }

        return right_heap.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        obj.addNum(-2);
        obj.addNum(-3);
        obj.addNum(-4);
        obj.addNum(-5);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
