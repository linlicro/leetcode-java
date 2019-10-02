package me.icro.learn.card.queuestack.queueandbfs.numsquares;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 *
 * @author Lin
 * @since 2019-10-02 4:46 PM
 */
public class Solution {
    public int numSquares(int n) {
        if (0 > n) {
            return -1;
        }

        int count = Integer.MAX_VALUE;
        int max_number = (int) Math.sqrt(n);
        for (int each = max_number; each > 0; each--) {
            count = Math.min(count, numSquares(n, each));
        }

        return count;
    }

    int numSquares(int n, int max_number) {
        int max_number_2 = max_number * max_number;
        if (max_number_2 > n) {
            return numSquares(n, max_number - 1);
        }
        int remainder = n % max_number_2;
        if (0 == remainder) {
            return n / max_number_2;
        } else {
            return n / max_number_2 + numSquares(remainder);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(43));
    }
}
