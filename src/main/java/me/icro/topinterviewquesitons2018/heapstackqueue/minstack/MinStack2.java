package me.icro.topinterviewquesitons2018.heapstackqueue.minstack;

import java.util.Stack;

/**
 * 描述:
 *
 * 利用空间换时间，辅助栈来记录最小值
 *
 * @author Lin
 * @since 2019-07-11 2:50 PM
 */
public class MinStack2 {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.empty() || helper.peek() >= x) {
            helper.push(x);
        }
    }

    public void pop() {
        if (data.empty()) return;
        int top = data.pop();
        if (top == helper.peek())
            helper.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
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
