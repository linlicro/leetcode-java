package me.icro.lcof.o10ifib;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @version v 0.1 2020/12/19
 **/
public class Solution {

    Map<Integer, Integer> map = new HashMap<>(100);

    public int fib(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = fib(n - 1) + fib(n - 2);
        if (res > 1000000007) {
            res %= 1000000007;
        }
        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(5));
        System.out.println(new Solution().fib(45));
    }
}
