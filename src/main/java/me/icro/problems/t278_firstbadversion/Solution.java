package me.icro.problems.t278_firstbadversion;

/**
 * 描述:
 * https://leetcode.com/problems/first-bad-version/
 *
 * @author Lin
 * @since 2019-05-19 7:46 PM
 */
public class Solution {
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

    boolean isBadVersion(int version) {
        if (version >= 1702766719) return true;
        return false;
    }
}
