package me.icro.problems.t887supereggdrop;

import java.util.HashMap;

/**
 *
 * 超时答案...
 *
 * @author lin
 * @version v 0.1 2020/9/15
 **/
public class Solution {

    /**
     * 备忘录
     */
    private HashMap<String, Integer> dict = new HashMap<>(8);

    public int superEggDrop(int K, int N) {

        // 假设dp(i, j)方法 有 j 个鸡蛋，在i楼丢下去，发生两种场景: 碎/不碎 >>
        // 每一层都尝试下: k[1 - i]
        // * 碎了，还需要尝试 dp(k - 1, j - 1)
        // * 没碎, 还需要尝试 dp(i - k, j)
        // > 取到的最坏情况是 max(dp(k - 1, j - 1), dp(i - k, j)) + 1，标记为M(k)
        // >> 而 每一层尝试后的最优值为，min(M(1), M(2), ..., M(i))

        return dp(N, K);
    }

    private int dp(int i, int j) {
        if (1 == j) {
            return i;
        }
        if (0 == i) {
            return 0;
        }
        if (dict.containsKey(String.format("%d+%d", i, j))) {
            return dict.get(String.format("%d+%d", i, j));
        }
        int res = i + 1;
        for (int k = 1; k < i + 1; k++) {
            int t1 = dp(k - 1, j - 1);
            int t2 = dp(i - k, j);
            res = Math.min(res, Math.max(t1, t2) + 1);
        }
        dict.put(String.format("%d+%d", i, j), res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().superEggDrop(1, 2));
        System.out.println(new Solution().superEggDrop(2, 3));
        System.out.println(new Solution().superEggDrop(2, 6));
        System.out.println(new Solution().superEggDrop(3, 14));
    }
}
