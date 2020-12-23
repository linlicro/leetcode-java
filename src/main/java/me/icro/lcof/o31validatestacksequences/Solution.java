package me.icro.lcof.o31validatestacksequences;

import java.util.Stack;

/**
 * @author lin
 * @version v 0.1 2020/12/23
 **/
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> data = new Stack<>();
        int index = 0;
        for (int value : pushed) {
            data.push(value);
            while (!data.empty() && data.peek() == popped[index]) {
                index++;
                data.pop();
            }
        }
        return data.empty();
    }
}
