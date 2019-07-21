package me.icro.topinterviewquesitons2018.heapstackqueue.nestediterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1160/
 *
 * @author Lin
 * @since 2019-07-21 2:29 PM
 */
public class NestedIterator implements Iterator<Integer> {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */

    private LinkedList<Integer> linkedList = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            offer(nestedInteger);
        }
    }

    @Override
    public Integer next() {
        return linkedList.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !linkedList.isEmpty();
    }

    void offer(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            linkedList.offer(nestedInteger.getInteger());
        } else {
            for (NestedInteger integer : nestedInteger.getList()) {
                offer(integer);
            }
        }
    }
}
