package me.icro.lcof.t30minstack;

import java.util.Stack;

/**
 * @author lin
 * @version v 0.1 2020/12/23
 **/
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
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
        if (data.empty()) {
            return;
        }
        int top = data.pop();
        if (top == helper.peek()) {
            helper.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return helper.peek();
    }
}
