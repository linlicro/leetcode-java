package me.icro.learn.sortandsearch.firstbadversion;

import java.util.Random;

/**
 * 描述:
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/53/
 *
 * @author Lin
 * @since 2019-05-19 5:05 PM
 */
public class Solution {
    public int firstBadVersion(int n) {
        return firstBadVersion(0, n);
    }

    public int firstBadVersion2(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low / 2 + high / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    int firstBadVersion(int m, int n) {
        if (m == n) return m;
        if (isBadVersion(m)) return m;
        int mid = m / 2 + n / 2;
        if (isBadVersion(mid)) return firstBadVersion(m, mid);
        else return firstBadVersion(mid + 1, n);
    }

    boolean isBadVersion(int version) {
        if (version >= 1702766719) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(2126753390));
        System.out.println(new Solution().firstBadVersion2(2126753390));
    }
}
