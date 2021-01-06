package me.icro.problems.t509fib;

/**
 * @author lin
 * @version v 0.1 2021/1/6
 **/
public class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(4));
        System.out.println(new Solution().fib(5));
    }
}
