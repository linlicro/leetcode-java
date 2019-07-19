package me.icro.topinterviewquesitons2018.heapstackqueue.calculate;

import java.util.*;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/266/heap-stack-queue/1159/
 *
 *  解题思路:
 *      * 使用堆栈
 *      * 先处理 乘除
 *      * 再处理 加减
 *
 * @author Lin
 * @since 2019-07-19 11:35 AM
 */
public class Solution {
    public int calculate(String s) {
        if (null == s || 0 == s.length())
            return 0;

        Map<Character, Integer> op_map = Collections.unmodifiableMap(new HashMap<Character, Integer>() {
            private static final long serialVersionUID = 8220577092842253464L;

            {
                put('+', 1);
                put('-', 2);
                put('*', 3);
                put('/', 4);
            }
        });

        LinkedList<Integer> linkedList = new LinkedList<>();

        // 处理 乘除
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur_number = c - '0';
                // 处理多位数
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur_number = cur_number * 10 + s.charAt(i + 1) - '0';
                    ++i;
                }
                // 若之前的是 乘除，先做运算，再压入结果
                if (!linkedList.isEmpty() && (3 == linkedList.peek() || 4 == linkedList.peek())) {
                    int op = linkedList.pop();
                    int pre_number = linkedList.pop();
                    int res = 0;
                    if (3 == op) res = pre_number * cur_number;
                    else res = pre_number / cur_number;
                    linkedList.push(res);
                } else {
                    linkedList.push(cur_number);
                }
            } else if (' ' == c) {
                continue;
            } else {
                linkedList.push(op_map.get(c));
            }
        }

        if (linkedList.isEmpty()) return 0;
        Collections.reverse(linkedList);

        // 处理 加减
        int res = linkedList.pop();
        while (!linkedList.isEmpty()) {
            int op = linkedList.pop();
            int next_number = linkedList.pop();
            if (1 == op) res += next_number;
            else res -= next_number;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1+2*3-1"));
    }
}
