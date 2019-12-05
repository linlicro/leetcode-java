package me.icro.learn.card.hashtable.practicalapplicationhashset.ishappy;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/hash-table/204/practical-application-hash-set/808/
 *
 * @author Lin
 * @since 2019-12-05 4:42 PM
 */
public class Solution {
    public boolean isHappy(int n) {
        if (1 == n) {
            return true;
        }

        Set<Integer> sadNumbers = new HashSet<>();
        sadNumbers.add(n);

        int nextNum = powerEachDigital(n);
        while (1 != nextNum
                && !sadNumbers.contains(nextNum)) {
            sadNumbers.add(nextNum);
            nextNum = powerEachDigital(nextNum);
        }

        if (1 == nextNum)
            return true;

        return false;
    }

    private int powerEachDigital(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(20));
        System.out.println(new Solution().isHappy(18));
    }
}
