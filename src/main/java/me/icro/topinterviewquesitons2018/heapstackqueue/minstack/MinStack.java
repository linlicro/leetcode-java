package me.icro.topinterviewquesitons2018.heapstackqueue.minstack;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1153/
 *
 * @author Lin
 * @since 2019-07-11 2:02 PM
 */
class MinStack {

    List<Integer> list;
    Integer min = Integer.MAX_VALUE;
    int index = -1;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
        if (x < min)
            min = x;
        index++;
    }

    public void pop() {
        if (-1 == index)
            return;
        Integer removeOne = list.remove(index);
        if (min.equals(removeOne) && index > 0) {
            min = list.get(0);
            list.forEach(p -> {
                if (p < min) {
                    min = p;
                }
            });
        } else if (index == 0){
            min = Integer.MAX_VALUE;
        }
        index--;
    }

    public int top() {
        return list.get(index);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        //minStack.push(-2);
        //minStack.push(0);
        //minStack.push(-3);
        //System.out.println(minStack.getMin());
        //minStack.pop();
        //System.out.println(minStack.top());
        //System.out.println(minStack.getMin());

        /**
         * ["minstack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
         [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
         */

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top()); // 2147483646 2147483646 2147483647
        minStack.pop(); // 2147483646 2147483646
        System.out.println(minStack.getMin());
        minStack.pop(); // 2147483646
        System.out.println(minStack.getMin());
        minStack.pop(); //
        minStack.push(2147483647); // 2147483647
        System.out.println(minStack.top()); // 2147483647
        System.out.println(minStack.getMin());// 2147483647
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * Your minstack object will be instantiated and called as such:
 * minstack obj = new minstack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
